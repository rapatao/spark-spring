package com.rapatao.sparkjava.spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define the handle method for an specified exception
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SparkExceptionHandler {

    /**
     * Define the exception to be handled in the method
     *
     * @return the exception class
     */
    Class<? extends Exception>[] value() default {};

}
