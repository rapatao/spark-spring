package com.rapatao.sparkjava.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rapatao.sparkjava.spring.configuration.SparkConfiguration;

import lombok.extern.slf4j.Slf4j;
import spark.Spark;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Slf4j
public class AnnotationAppInitializerTest {

    private static final SparkConfiguration sparkConfiguration = SparkConfiguration.builder().port(4569).build();

    @BeforeClass
    public static void oneTimeSetUp() {
        AnnotationAppInitializer.initialize(sparkConfiguration);
        Spark.awaitInitialization();
    }

    @AfterClass
    public static void oneTimeTearDown() {
        Spark.stop();
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
            log.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

}