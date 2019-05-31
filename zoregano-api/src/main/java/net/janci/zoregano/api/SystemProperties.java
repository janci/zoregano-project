package net.janci.zoregano.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@link SystemProperty} container. Opens accessibility, that {@link SystemProperty} can be repeatable.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.MODULE)
public @interface SystemProperties {

    /**
     * Kinds of repeated {@link SystemProperty}.
     *
     * @return Kinds of repeated {@link SystemProperty}.
     */
    SystemProperty[] value();
}
