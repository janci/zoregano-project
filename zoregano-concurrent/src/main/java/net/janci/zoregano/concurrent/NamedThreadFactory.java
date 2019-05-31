package net.janci.zoregano.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Special version of {@link ThreadFactory}, that can be named.
 * This thread factory creates named threads as "prefix"-"threadNumber"
 * Named thread are better managed and serviced by third party java tools.
 */
public class NamedThreadFactory implements ThreadFactory {

    private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private String prefix;

    /**
     * Default constructor. Example, how this class can be used:
     * <pre>
     *   Executors.newCachedThreadPool(new NamedThreadFactory("bios-module"));
     * <pre/>
     *
     * @param prefix    String, that will be before every thread, that will be created.
     */
    public NamedThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Factory to create new daemon thread with prefixed name.
     *
     * @param r     A runnable to be executed by new thread instance.
     * @return constructed thread.
     */
    public Thread newThread(Runnable r) {
        Thread thread = this.defaultFactory.newThread(r);
        if (!thread.isDaemon()) {
            thread.setDaemon(true);
        }

        thread.setName(this.prefix + "-" + this.threadNumber.getAndIncrement());
        return thread;
    }
}
