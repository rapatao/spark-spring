package com.github.rascorp.spark.spring.registry;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.rascorp.spark.spring.SparkController;
import com.github.rascorp.spark.spring.annotations.SparkRequestHandler;
import com.github.rascorp.spark.spring.configuration.SparkConfiguration;
import com.github.rascorp.spark.spring.exceptions.SparkRegistryException;

import spark.Route;
import spark.Spark;

/**
 * Registry all Spark Controllers
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Component
public class ControllerRegistry implements Registry {

    /**
     * Utility class to iterate all methods to registry the Spark handlers
     */
    private static final class SparkMethodRegistry {
        private static void registry(final SparkController sparkController,
                                     final Method method) {
            Arrays.stream(method.getDeclaredAnnotationsByType(SparkRequestHandler.class)).forEach(element -> {
                SparkRequestHandlerRegistry.registry(sparkController, method, element);
            });
        }

    }

    /**
     * Utility class to iterate all fields with {@link SparkRequestHandler} to create the {@link Route} for Spark
     */
    private static final class SparkRequestHandlerRegistry {
        private static void registry(final SparkController sparkController,
                                     final Method method,
                                     final SparkRequestHandler sparkRequestHandler) {

            Arrays.stream(sparkRequestHandler.requestMethod()).forEach(requestMethods -> {
                Route route = (request, response) -> method.invoke(sparkController, request, response);
                String path = sparkController.getRootPath() + sparkRequestHandler.path();

                // TODO change to use a transform using response type
                switch(requestMethods) {
                    case GET:
                        Spark.get(path, route);
                        break;
                    case POST:
                        Spark.post(path, route);
                        break;
                    case DELETE:
                        Spark.delete(path, route);
                        break;
                    case OPTIONS:
                        Spark.options(path, route);
                        break;
                    case PUT:
                        Spark.put(path, route);
                        break;
                    default:
                        throw new SparkRegistryException("Request scope not defined");
                }
            });

        }
    }

    @Autowired
    private List<SparkController> sparkControllers;

    /**
     * Registry all Spark Controllers
     *
     * @param sparkConfiguration the spark configuration
     */
    @Override
    public void registry(final SparkConfiguration sparkConfiguration) {
        if (sparkControllers == null || sparkControllers.isEmpty()) {
            throw new SparkRegistryException("Not found any class of type " + SparkController.class.getName());
        }

        sparkControllers.stream().forEach(sparkController -> {
            Arrays.stream(sparkController.getClass().getDeclaredMethods()).forEach(method -> {
                SparkMethodRegistry.registry(sparkController, method);
            });
        });
    }

}
