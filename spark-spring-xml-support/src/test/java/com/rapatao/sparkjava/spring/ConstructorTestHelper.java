package com.rapatao.sparkjava.spring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public final class ConstructorTestHelper {

    public static void testPrivateConstructorNoArguments(Class<?> clazz) {
        try {
            final Constructor constructor = clazz.getDeclaredConstructor();
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            assertNotNull(constructor.newInstance());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
