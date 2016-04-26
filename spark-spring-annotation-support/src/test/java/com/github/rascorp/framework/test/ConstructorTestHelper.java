package com.github.rascorp.framework.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public final class ConstructorTestHelper {

    public static void testPrivateConstructorNoArguments(Class<?> clazz) {
        try {
            Constructor constructor = clazz.getDeclaredConstructor();
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            Object o = constructor.newInstance();
            assertNotNull(o);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
