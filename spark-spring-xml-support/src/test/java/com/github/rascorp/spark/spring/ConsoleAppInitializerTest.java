package com.github.rascorp.spark.spring;

import static com.github.rascorp.framework.test.ConstructorTestHelper.testPrivateConstructorNoArguments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

import spark.Spark;

/**
 * @author Luiz Henrique Rapatao <rapatao@rapatao.com>
 * @since 13/04/2016
 */
public class ConsoleAppInitializerTest {

    private static final SparkConfiguration sparkConfiguration = SparkConfiguration.builder().port(4568).build();

    @AfterClass
    public static void finish() {
        Spark.stop();
    }

    @BeforeClass
    public static void setup() {
        ConsoleAppInitializer.initialize(sparkConfiguration, "application-context-spark-spring-test.xml");
    }

    @Test
    public void testContext() {
        try {
            URL url = new URL("http://0.0.0.0:4568/method1");
            final URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            final String response = bufferedReader.readLine();
            Assert.assertEquals("method1", response);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testPrivateConstructor() {
        testPrivateConstructorNoArguments(ConsoleAppInitializer.class);
    }

}