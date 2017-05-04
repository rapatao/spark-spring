package com.rapatao.sparkjava.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rapatao.sparkjava.spring.configuration.SparkConfiguration;
import com.rapatao.sparkjava.spring.registry.Registry;

/**
 * Spring bean class to registry all Spark configuration
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Component
public class SparkRegistryUtil {

    @Autowired
    private List<Registry> registries;

    /**
     * Iterate all Spring bean of {@link Registry} type to execute the Spark context
     */
    public void registry(final SparkConfiguration sparkConfiguration) {
        registries.stream()
                  .sorted((a, b) -> a.order().compareTo(b.order()))
                  .forEach(registry -> registry.registry(sparkConfiguration));

    }

}
