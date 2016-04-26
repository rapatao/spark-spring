package com.github.rascorp.spark.spring.registry;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
public interface Registry {

    void registry(final SparkConfiguration sparkConfiguration);

    default Integer weigh() {
        return 1;
    }
}
