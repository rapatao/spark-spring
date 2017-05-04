package com.rapatao.sparkjava.spring;

import com.rapatao.sparkjava.spring.annotations.SparkRequestHandler;

/**
 * Define the contract of all Spark Controllers.
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public interface SparkController {

    /**
     * Get the root path for all context declared in handler methods.
     * <p>
     * Default: "".
     * <p>
     * If a {@link SparkController} overrides this method, the value returned is concatenated in all declared handler methods paths.
     * <p>
     * Ex.:
     * <p>
     * When {@link SparkController#getRootPath} returns "/api/v1" and the declared path in {@link SparkRequestHandler#path()} returns "/users"
     * then the service will be invoked in the URL: "/api/v1/users".
     *
     * @return the root context path for all handlers declared in the controller.
     */
    default String getRootPath() {
        return "";
    }

}
