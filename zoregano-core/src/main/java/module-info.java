import net.janci.zoregano.api.SystemProperty;
import net.janci.zoregano.core.internal.KernelFinder;

/**
 * Default bootloader for Zoregano System.
 */
@SystemProperty(value = KernelFinder.PREFERRED_CLASS_PROPERTY_NAME, description = "Define kernel class name")
module zoregano.core {
    requires zoregano.api;
    requires zoregano.concurrent;

    uses net.janci.zoregano.api.Kernel;
    uses net.janci.zoregano.api.BIOSModule;

    exports net.janci.zoregano.core;
}
