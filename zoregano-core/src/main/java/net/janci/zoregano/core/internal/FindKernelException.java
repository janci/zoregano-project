package net.janci.zoregano.core.internal;

/**
 * Exception class for signal problem with find {@link net.janci.zoregano.api.Kernel}
 * in the {@link KernelFinder}
 *
 * @see KernelFinder
 * @see net.janci.zoregano.api.Kernel
 */
public class FindKernelException extends Exception {
    FindKernelException(String message) {
        super(message);
    }
}
