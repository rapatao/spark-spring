package com.github.rascorp.spark.spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define the handle method for an specified http method and request path.
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SparkRequestHandler {

    /**
     * Define supported http request methods types
     */
    enum RequestMethod {
        GET, POST, PUT, DELETE, OPTIONS
    }

    /**
     * Define supported response type
     */
    enum ResponseType {
        JSON, NONE
    }

    /**
     * the service URL.
     *
     * @return service URL.
     */
    String path();

    /**
     * Define all supported request methods.
     *
     * @return supported methods
     */
    RequestMethod[] requestMethod() default {RequestMethod.GET};

    /**
     * Define the response type
     *
     * @return response type
     */
    ResponseType responseType() default ResponseType.NONE;

}
