package com.github.rascorp.spark.spring.factory;

import spark.Route;

/**
 * Define the interface for registry all Request Methods
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
public interface RequestMethodFactory {

    /**
     * @param path  the application relative path for the handler
     * @param route the wrapper router that invoke the request method
     */
    void registry(final String path, final Route route);

}
