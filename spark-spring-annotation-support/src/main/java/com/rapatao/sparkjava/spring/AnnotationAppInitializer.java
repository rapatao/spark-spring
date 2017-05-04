package com.rapatao.sparkjava.spring;

import com.rapatao.sparkjava.spring.configuration.SparkConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Configuration
@ComponentScan(basePackageClasses = AnnotationAppInitializer.class)
public class AnnotationAppInitializer {

    public static void initialize(final SparkConfiguration sparkConfiguration,
                                  final Class<?>... configurationClasses) {

        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AnnotationAppInitializer.class);
        if (configurationClasses != null && configurationClasses.length > 0) {
            annotationConfigApplicationContext.register(configurationClasses);
        }
        annotationConfigApplicationContext.refresh();
        final SparkRegistryUtil bean = annotationConfigApplicationContext.getBean(SparkRegistryUtil.class);
        bean.registry(sparkConfiguration);
    }
}
