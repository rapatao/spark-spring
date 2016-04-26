package com.github.rascorp.framework.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public final class ConstructorTestHelper {

    public static void testPrivateConstructorNoArguments(Class<?> clazz) throws Exception {
        Constructor constructor = clazz.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        Object o = constructor.newInstance();
        assertNotNull(o);
    }

}
