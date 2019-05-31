package net.janci.zoregano.api;

import java.lang.annotation.*;

/**
 * Annotation extend module-info options to inform all modules about existence of system property.
 * The property should may be returns by {@link System#getProperty}, when it was added during execution application.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.MODULE)
@Repeatable(SystemProperties.class)
public @interface SystemProperty {

    /**
     * Property name or also named as key, that can be use during start application (-D&lt;key&gt;=&lt;value&gt;).
     * @return Property name.
     */
    String value();

    /**
     * Long description of property name for describe the property.
     * @return Description of property name.
     */
    String description() default "";
}
