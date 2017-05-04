package com.rapatao.sparkjava.spring.registry.controller;

import com.rapatao.sparkjava.spring.SparkController;
import com.rapatao.sparkjava.spring.annotations.SparkRequestHandler;
import com.rapatao.sparkjava.spring.exceptions.SparkRegistryException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import spark.Route;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Spark Request Handler Register
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SparkRequestHandlerRegistry {

    /**
     * Iterate all fields with {@link SparkRequestHandler} to create the {@link Route} for Spark
     *
     * @param sparkController
     * @param method
     * @param sparkRequestHandler
     */
    public static void registry(final SparkController sparkController,
                                final Method method,
                                final SparkRequestHandler sparkRequestHandler) {
        Arrays.stream(sparkRequestHandler.requestMethod()).forEach(requestMethod -> {
            Route route = (request, response) -> method.invoke(sparkController, request, response);
            String path = sparkController.getRootPath() + sparkRequestHandler.path();
            if (requestMethod != null) {
                requestMethod.registry(path, route);
            } else {
                throw new SparkRegistryException("Request scope not defined");
            }
        });
    }
}
