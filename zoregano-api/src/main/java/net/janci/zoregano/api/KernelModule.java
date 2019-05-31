package net.janci.zoregano.api;

/**
 * Kernel modules are loaded, when {@link Kernel} is successfully started. Which module will be
 * started, and which module no, manage {@link Kernel}. It means, that any module may not be running at all.
 *
 * Module should be isolated and should not have any "hard" dependency to other module.
 *
 * Also, start of modules is managed by {@link Kernel}, but there is no secured the order.
 */
public interface KernelModule {
    /**
     * Start module and prepare all, what module need for correctly running.
     */
    void load();

    /**
     * Stop module, stop all threads managed by module and release resources.
     */
    void unload();
}
