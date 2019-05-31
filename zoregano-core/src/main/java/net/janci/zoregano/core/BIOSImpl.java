package net.janci.zoregano.core;

import net.janci.zoregano.api.BIOS;
import net.janci.zoregano.api.BIOSModule;
import net.janci.zoregano.concurrent.NamedThreadFactory;

import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Default implementation for {@link BIOS} interface.
 *
 * @see BIOS
 */
public class BIOSImpl implements BIOS {

    private String[] args;

    private ExecutorService moduleLoaderExecutor = Executors.newCachedThreadPool(new NamedThreadFactory("bios-module"));

    private List<BIOSModule> loadedBIOSModules;

    private CountDownLatch latch;

    BIOSImpl(String[] args) {
        this.args = args;

        ServiceLoader<BIOSModule> biosModules = ServiceLoader.load(BIOSModule.class);

        loadedBIOSModules = biosModules.stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loadBIOSModules() {
        latch = new CountDownLatch(loadedBIOSModules.size());
        loadedBIOSModules.parallelStream()
                .forEach(module -> moduleLoaderExecutor.execute(() -> {
                    module.load(args);
                    latch.countDown();
                }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void awaitToStartKernel() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void terminate() {
        loadedBIOSModules.parallelStream().forEach(BIOSModule::unload);
    }
}
