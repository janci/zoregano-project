package net.janci.zoregano.api.config;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Stream;

/**
 * Class represent configuration container and it have responsibility to return correctly sub-configuration
 * by specific key.
 *
 * Standard system ConfigurationFactory class can be obtained by {@link ConfigurationFactory#getInstance()}.
 */
public interface ConfigurationFactory {

    /**
     * Returns sub-configuration by name.
     *
     * Example for returns configuration for kernel can be:
     * <pre>
     *     ConfigurationFactory.getInstance().getConfiguration("kernel");
     * </pre>
     *
     * @param config configuration name
     * @return  configuration, that is represent for configuration name, or empty configuration,
     *          when configuration is not available.
     */
    Configuration getConfiguration(String config);

    /**
     * Check, that configuration with the name can be obtained.
     *
     * @param config configuration name
     * @return  true, when sub-configuration with name is available, otherwise false.
     */
    boolean containsConfiguration(String config);

    /**
     * Factory to create new empty configuration.
     *
     * @return new empty configuration, that it can be filled and stored.
     */
    Configuration emptyConfiguration();

    /**
     * Found correctly configuration factory in the system and returns it.
     *
     * {@link ConfigurationFactory} can be defined by system property -Dconfig.factory-class. If the definition exists,
     * loading this class has most priority.
     *
     * If {@link ConfigurationFactory} system property is not defined,
     * {@link Stream#findFirst()} on the {@link ServiceLoader#load(Class)} is used to construct new instance.
     *
     * Every time, when method is called, new instance is created.
     *
     * When in the system non-exists any {@link ConfigurationFactory} as service or {@link ConfigurationFactory} by defined
     * system parameter doesn't obtained, method returns null.
     *
     * @return instance of implementation ConfigurationFactory
     */
    static ConfigurationFactory getInstance() {
        ServiceLoader<ConfigurationFactory> configFactoryService = ServiceLoader.load(ConfigurationFactory.class);
        String configFactoryClass = System.getProperty("config.factory-class");
        if (configFactoryClass != null) {
            return configFactoryService.stream()
                    .filter(p ->p.type().getName().equals(configFactoryClass))
                    .findAny().map(ServiceLoader.Provider::get).orElse(null);
        }

        Optional<ConfigurationFactory> configurationFactoryOpt = configFactoryService.findFirst();
        return configurationFactoryOpt.orElse(null);
    }
}
