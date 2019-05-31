package net.janci.zoregano.api;

/**
 * Name of tha class has symbolic in the Linux Kernel. When {@link BIOS} and {@link BIOSModule} modules
 * started, system delegate initialization process to Kernel.
 *
 * Kernel class is creating by {@link java.util.ServiceLoader}.
 */
public interface Kernel {

    /**
     * Initialize kernel and start all modules of type {@link KernelModule}.
     */
    void init();

    /**
     * Terminate all loaded before loaded modules of type {@link KernelModule}.
     * All processes loaded and initialized by kernel should by correctly closed and resources released.
     */
    void terminate();

    /**
     * Getter for KernelController of currently loaded kernel.
     * @return  KernelController related to loaded Kernel.
     */
    KernelController getController();
}
