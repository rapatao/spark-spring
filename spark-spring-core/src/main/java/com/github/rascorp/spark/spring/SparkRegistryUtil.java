package com.github.rascorp.spark.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;
import com.github.rascorp.spark.spring.registry.Registry;

/**
 * Spring bean class to registry all Spark configuration
 *
 * @author Luiz Henrique Rapatao <rapatao@rapatao.com>
 * @since 13/04/2016
 */
@Component
public class SparkRegistryUtil {

    @Autowired
    private List<Registry> registries;

    // @Autowired
    // private SparkConfigurationRegistry sparkConfigurationRegistry;

    /**
     * Iterate all Spring bean of {@link Registry} type to execute the Spark context
     */
    public void registry(final SparkConfiguration sparkConfiguration) {
        // sparkConfigurationRegistry.registry(sparkConfiguration);
        registries.stream().sorted((a, b) -> a.weigh().compareTo(b.weigh()))
                  // .filter(element -> (element instanceof SparkConfigurationRegistry))
                  .forEach(registry ->
                                   registry.registry(sparkConfiguration)
                          );

    }

}
