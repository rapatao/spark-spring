package com.github.rascorp.spark.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Create XML based for Spring Context and configure all Spark resources.
 *
 * @author Luiz Henrique Rapatao <rapatao@rapatao.com>
 * @since 13/04/2016
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConsoleAppInitializer {

    /**
     * Initialize the Spring context based on {@link SparkConfiguration} and a Spring XML File configuration
     *
     * @param sparkConfiguration the spark configuration
     * @param mainConfigFile     the spring context xml file
     */
    public static void initialize(final SparkConfiguration sparkConfiguration,
                                  final String mainConfigFile) {
        final ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext(mainConfigFile);
        final SparkRegistryUtil bean = xmlApplicationContext.getBean(SparkRegistryUtil.class);
        bean.registry(sparkConfiguration);
    }

}
