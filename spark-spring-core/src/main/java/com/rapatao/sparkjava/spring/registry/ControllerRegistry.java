package com.rapatao.sparkjava.spring.registry;

import com.rapatao.sparkjava.spring.SparkController;
import com.rapatao.sparkjava.spring.configuration.SparkConfiguration;
import com.rapatao.sparkjava.spring.exceptions.SparkRegistryException;
import com.rapatao.sparkjava.spring.registry.controller.SparkMethodRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Registry all Spark Controllers
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Component
public class ControllerRegistry implements Registry {

    @Autowired
    private List<SparkController> sparkControllers;

    /**
     * Registry all Spark Controllers
     *
     * @param sparkConfiguration the spark configuration
     */
    @Override
    public void registry(final SparkConfiguration sparkConfiguration) {
        if (sparkControllers.isEmpty()) {
            throw new SparkRegistryException("Not found any class of type " + SparkController.class.getName());
        }
        sparkControllers.stream().forEach(sparkController ->
                Arrays.stream(sparkController.getClass().getDeclaredMethods()).forEach(
                        method -> SparkMethodRegistry.registry(sparkController, method)));
    }

}
