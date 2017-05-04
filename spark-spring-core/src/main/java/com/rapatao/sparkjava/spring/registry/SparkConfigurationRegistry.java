package com.rapatao.sparkjava.spring.registry;

import com.rapatao.sparkjava.spring.configuration.SparkConfiguration;
import org.springframework.stereotype.Component;

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
