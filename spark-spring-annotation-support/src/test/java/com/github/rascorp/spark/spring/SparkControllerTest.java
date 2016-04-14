package com.github.rascorp.spark.spring;

import org.springframework.stereotype.Component;

import com.github.rascorp.spark.spring.annotations.SparkRequestHandler;

import spark.Request;
import spark.Response;

/**
 * @author Luiz Henrique Rapatao <rapatao@rapatao.com>
 * @since 13/04/2016
 */
@Component
public class SparkControllerTest implements SparkController {

    @SparkRequestHandler(path = "/method1", requestMethod = {
            SparkRequestHandler.RequestMethod.GET,
            SparkRequestHandler.RequestMethod.POST
    })
    public String method1(final Request request,
                          final Response response) {
        return "method1";
    }

    @SparkRequestHandler(path = "/method2", requestMethod = {
            SparkRequestHandler.RequestMethod.DELETE,
            SparkRequestHandler.RequestMethod.OPTIONS
    })
    public Integer method2(final Request request,
                           final Response response) {
        return 2;
    }

    @SparkRequestHandler(path = "/method3", requestMethod = SparkRequestHandler.RequestMethod.PUT)
    public Object method3(final Request request,
                          final Response response) {
        return "method3";
    }

}
