package net.janci.zoregano.api;

/**
 * Bios in the Zoregano framework represent class that is loaded as first.
 * This class load all BIOS modules prepared Kernel and load it.
 * When application is finished, Kernel and all BIOS modules must be correctly unloaded
 * from system.
 *
 * @see BIOSModule
 * @see Kernel
 */
public interface BIOS {

    /** Load all modules. */
    void loadBIOSModules();

    /** Start kernel and waiting to finish it. When method is done, system can be terminated.*/
    void awaitToStartKernel();

    /** Kernel and all loaded modules are unloaded. */
    void terminate();
}
