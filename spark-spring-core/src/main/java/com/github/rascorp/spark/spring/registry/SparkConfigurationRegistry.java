package com.github.rascorp.spark.spring.registry;

import org.springframework.stereotype.Component;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

import spark.Spark;

/**
 * Registry to configure embedded Jetty
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Component
public class SparkConfigurationRegistry implements Registry {

    /**
     * Registry all Spark configuration
     *
     * @param sparkConfiguration the spark configuration
     */
    @Override
    public void registry(final SparkConfiguration sparkConfiguration) {
        if (sparkConfiguration != null) {
            Spark.port(sparkConfiguration.getPort());
        }
    }

    @Override
    public Integer order() {
        return 1;
    }

}
