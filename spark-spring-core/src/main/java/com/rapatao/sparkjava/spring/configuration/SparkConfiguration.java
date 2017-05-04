package com.rapatao.sparkjava.spring.configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represent the Spark Jetty Configuration
 *
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SparkConfiguration {

    public static final int DEFAULT_SERVER_PORT = 4567;

    /**
     * Define the server port
     * <p>
     * Default: 4567
     */
    @Getter
    private Integer port = DEFAULT_SERVER_PORT;

}
