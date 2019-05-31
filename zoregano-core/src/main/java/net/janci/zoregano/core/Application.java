package net.janci.zoregano.core;

import net.janci.zoregano.api.BIOS;
import net.janci.zoregano.api.Kernel;
import net.janci.zoregano.core.internal.FindKernelException;
import net.janci.zoregano.core.internal.KernelFinder;

/**
 * Main Class for Zoregano System. Class start BIOS,
 * load BIOSModules and delegate processing to Kernel.
 */
public class Application {


    /**
     * Initialize Zoregano Application.
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        BIOS bios = new BIOSImpl(args);
        bios.loadBIOSModules();
        bios.awaitToStartKernel();

        try {
            Kernel kernel = new KernelFinder().findKernel();
            kernel.getController().setAsDefaultInstance();
            kernel.init();
            kernel.terminate();
        } catch (FindKernelException e) {
            System.err.println(e.getMessage());
        }

        bios.terminate();
    }
}
