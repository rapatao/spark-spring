package com.github.rascorp.spark.spring.exceptions;

/**
 * Generic exception
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 01/05/2016.
 */
public class SparkSpringException extends RuntimeException {

    /**
     * Create a SparkSpringException with message
     *
     * @param message the exception message
     */
    public SparkSpringException(final String message) {
        super(message);
    }

    /**
     * Create a SparkSpringException with a message and exception
     *
     * @param message   the exception message
     * @param throwable the origin exception
     */
    public SparkSpringException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
