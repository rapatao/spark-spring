package com.github.rascorp.spark.spring.factory;

import spark.Route;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
public interface RequestMethodFactory {

    void registry(final String path, final Route route);

}
