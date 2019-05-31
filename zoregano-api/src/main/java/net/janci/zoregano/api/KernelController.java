package net.janci.zoregano.api;

/**
 * KernelController is class, that open control mechanism to other class in the system.
 * For example: when some {@link KernelModule} can restart completely {@link Kernel}.
 *
 * @see KernelModule
 * @see Kernel
 */
public abstract class KernelController {

    private static KernelController systemInstance;

    /**
     * Restart related {@link Kernel}.
     */
    abstract public void restart();

    /**
     * Stop specific {@link KernelModule}, before loaded by {@link Kernel}.
     *
     * @param moduleClass   Kernel module class.
     */
    abstract public void stopModule(Class<KernelModule> moduleClass);

    /**
     * Start specific {@link KernelModule}.
     *
     * @param moduleClass   Kernel module class.
     */
    abstract public void startModule(Class<KernelModule> moduleClass);

    /**
     * The controller will be marked as system {@link Kernel} controller.
     */
    public void setAsDefaultInstance() {
        systemInstance = this;
    }

    /**
     * Get system {@link Kernel} controller.
     *
     * @return  Controller, that was last marked as "system {@link Kernel} controller".
     */
    static KernelController getInstance() {
        return systemInstance;
    }
}
