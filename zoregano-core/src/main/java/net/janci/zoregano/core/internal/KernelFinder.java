package net.janci.zoregano.core.internal;

import net.janci.zoregano.api.Kernel;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Find {@link Kernel} in the Zoregano System.
 */
public class KernelFinder {

    /**
     * Property name to search {@link Kernel} class.
     */
    public final static String PREFERRED_CLASS_PROPERTY_NAME = "kernel";

    /**
     * Find {@link Kernel} in the Zoregano System.
     *
     * Most priority for select {@link Kernel} has system property -Dkernel=&lt;class&gt;.
     * When this property does not obtained, {@link Kernel} is loaded automatically,
     * finding service by {@link ServiceLoader#load(Class)}. But if no {@link Kernel} found,
     * or more as one {@link Kernel} is found, {@link FindKernelException} throw.
     *
     * @return kernel interface implementation defined as system kernel
     *
     * @throws FindKernelException when, defined class by system property -Dkernel not exists, or
     *                             when, non-exists class implement {@link Kernel} interface, or
     *                             when, more as one class that implement {@link Kernel} exists in the system.
     *
     */
    public Kernel findKernel() throws FindKernelException {
        String serverClassName = System.getProperty(PREFERRED_CLASS_PROPERTY_NAME);

        ServiceLoader<Kernel> kernelLoader = ServiceLoader.load(Kernel.class);

        if (serverClassName == null) {
            Iterator<Kernel> kernelIterator = kernelLoader.iterator();

            if (!kernelIterator.hasNext()) {
                throw new FindKernelException("Not found any kernel in the system.");
            }

            Kernel kernel = kernelIterator.next();

            if (kernelIterator.hasNext()) {
                throw new FindKernelException("Find more as one kernel in the system. Please specify kernel by property 'kernel.class')");
            }

            return kernel;
        }

        return kernelLoader.stream()
                .filter(ws -> ws.type().getName().equals(serverClassName))
                .findAny().map(ServiceLoader.Provider::get)
                .orElseThrow(() -> new FindKernelException("Kernel Class '" + serverClassName + "' not found by service loader."));
    }
}
