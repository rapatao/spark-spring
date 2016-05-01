package com.github.rascorp.spark.spring.registry;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public interface Registry {

    /**
     * Registry the spark component
     *
     * @param sparkConfiguration the spark configuration
     */
    void registry(final SparkConfiguration sparkConfiguration);

    /**
     * Defines the component run order.
     * <p>
     * The execution starts with the lower values.
     *
     * @return the order of the component
     */
    default Integer order() {
        return 10;
    }
}
