package com.github.rascorp.spark.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.rascorp.spark.spring.configuration.SparkConfiguration;

import spark.Spark;

/**
 * @author Luiz Henrique Rapatao <rapatao@rapatao.com>
 * @since 13/04/2016
 */
public class AnnotationAppInitializerTest {

    private static final SparkConfiguration sparkConfiguration = SparkConfiguration.builder().port(4569).build();

    public static void finish() {
        Spark.stop();
    }

    @BeforeClass
    public static void setup() {
        AnnotationAppInitializer.initialize(sparkConfiguration);
    }

    @Test
    public void testContext() {
        try {
            URL url = new URL("http://0.0.0.0:4569/method1");
            final URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            final String response = bufferedReader.readLine();
            Assert.assertEquals("method1", response);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

}