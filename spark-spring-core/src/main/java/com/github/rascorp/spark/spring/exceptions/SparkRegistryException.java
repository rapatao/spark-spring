package com.github.rascorp.spark.spring.exceptions;

/**
 * Exception to throws any exception when registering the Spark components.
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public class SparkRegistryException extends RuntimeException {

    /**
     * Create the SparkRegistryException
     *
     * @param message the exception message
     */
    public SparkRegistryException(String message) {
        super(message);
    }

}
