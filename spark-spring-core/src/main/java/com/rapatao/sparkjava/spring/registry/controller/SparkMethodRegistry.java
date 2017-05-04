package com.rapatao.sparkjava.spring.registry.controller;

import com.rapatao.sparkjava.spring.SparkController;
import com.rapatao.sparkjava.spring.annotations.SparkExceptionHandler;
import com.rapatao.sparkjava.spring.annotations.SparkRequestHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Spark Method Registry
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SparkMethodRegistry {

    /**
     * Iterate all methods to registry all Spark handlers
     *
     * @param sparkController
     * @param method
     */
    public static void registry(final SparkController sparkController,
                                final Method method) {
        Arrays.stream(method.getDeclaredAnnotationsByType(SparkRequestHandler.class)).forEach(
                sparkRequestHandler -> SparkRequestHandlerRegistry.registry(
                        sparkController, method, sparkRequestHandler));

        Arrays.stream(method.getDeclaredAnnotationsByType(SparkExceptionHandler.class)).forEach(
                sparkExceptionHandler -> SparkExceptionHandlerRegistry.registry(
                        sparkController, method, sparkExceptionHandler));
    }
}
