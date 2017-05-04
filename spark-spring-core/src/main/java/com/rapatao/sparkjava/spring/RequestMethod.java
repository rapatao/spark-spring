package com.rapatao.sparkjava.spring;

import com.rapatao.sparkjava.spring.factory.RequestMethodFactory;
import spark.Route;
import spark.Spark;

/**
 * Define supported http request methods types and implement the Spark method registry
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
public enum RequestMethod implements RequestMethodFactory {

    GET {
        @Override
        public void registry(String path, Route route) {
            Spark.get(path, route);
        }
    },
    POST {
        @Override
        public void registry(String path, Route route) {
            Spark.post(path, route);
        }
    },
    PUT {
        @Override
        public void registry(String path, Route route) {
            Spark.put(path, route);
        }
    },
    DELETE {
        @Override
        public void registry(String path, Route route) {
            Spark.delete(path, route);
        }
    },
    OPTIONS {
        @Override
        public void registry(String path, Route route) {
            Spark.options(path, route);
        }
    }

}
