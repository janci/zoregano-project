import net.janci.zoregano.api.SystemProperty;

/**
 * Define base interfaces and abstract classes for Zoregano Framework. The package used by {@link net.janci.zoregano.api.KernelModule} or {@link net.janci.zoregano.api.BIOSModule}
 * classes, that extend Zoregano functionality.
 */
@SystemProperty(value = "config.factory-class", description = "Define configuration factory class, that will be use in the application.")
module zoregano.api {
    exports net.janci.zoregano.api;
    exports net.janci.zoregano.api.config;

    uses net.janci.zoregano.api.config.ConfigurationFactory;
}
