package net.janci.zoregano.concurrent;

import java.util.concurrent.ThreadFactory;

import static org.junit.jupiter.api.Assertions.*;

class NamedThreadFactoryTest {

    @org.junit.jupiter.api.Test
    void testNewNamedThread() {
        ThreadFactory tf = new NamedThreadFactory("test-x99");
        Thread t = tf.newThread(() -> {});

        assertNotNull(t);
        assertNotNull(t.getName());
        assertTrue(t.getName().startsWith("test-x99-"));
    }
}
