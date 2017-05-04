package com.rapatao.sparkjava.spring.registry.controller;

import com.rapatao.sparkjava.spring.SparkController;
import com.rapatao.sparkjava.spring.annotations.SparkExceptionHandler;
import com.rapatao.sparkjava.spring.exceptions.SparkSpringException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import spark.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SparkExceptionHandlerRegistry {

    /**
     * Iterate all fields with {@link SparkExceptionHandler} to create the {@link Route} for Spark
     *
     * @param sparkController
     * @param method
     * @param sparkExceptionHandler
     */
    static void registry(final SparkController sparkController,
                         final Method method,
                         final SparkExceptionHandler sparkExceptionHandler) {
        Arrays.stream(sparkExceptionHandler.value()).forEach(
                clazz -> {
                    ExceptionHandler exceptionHandler =
                            (Exception e, Request request, Response response) -> {
                                try {
                                    method.invoke(sparkController, request, response, e);
                                } catch (IllegalAccessException | InvocationTargetException ex) {
                                    throw new SparkSpringException(e.getMessage(), e);
                                }
                            };
                    Spark.exception(clazz, exceptionHandler);
                });
    }

}
