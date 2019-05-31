package net.janci.zoregano.api;

/**
 * Also named as first level modules in the system. This modules mostly have responsibility
 * to input/output initialization of system. For example as CLI, Logging, e.g.
 *
 * BIOS modules are started before load Kernel. Objects of class are initializing by Java
 * {@link java.util.ServiceLoader}.
 *
 * @see BIOS
 */
public interface BIOSModule {

    /**
     * Initialize module. The method must be non-blocked for long time. If module need do long
     * operation, you can start separately thread. {@link BIOS} waiting to load all modules and when
     * all modules are loaded, {@link Kernel} can be started.
     *
     * @param args
     *        Application arguments.
     */
    void load(String[] args);

    /**
     * Before loaded module is correctly finished, unloaded from memory and prepared to finish.
     * All threads started by module must be correctly finished.
     */
    void unload();
}
