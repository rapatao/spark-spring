package com.rapatao.sparkjava.spring;

import com.rapatao.sparkjava.spring.annotations.SparkRequestHandler;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;

/**
 * @author Luiz Henrique Rapatao - rapatao@rapatao.com
 * @since 13/04/2016
 */
@Component
public class SparkControllerTest implements SparkController {

    @SparkRequestHandler(path = "/method1", requestMethod = {
            RequestMethod.GET,
            RequestMethod.POST
    })
    public String method1(final Request request,
                          final Response response) {
        return "method1";
    }

    @SparkRequestHandler(path = "/method2", requestMethod = {
            RequestMethod.DELETE,
            RequestMethod.OPTIONS
    })
    public Integer method2(final Request request,
                           final Response response) {
        return 2;
    }

    @SparkRequestHandler(path = "/method3", requestMethod = RequestMethod.PUT)
    public Object method3(final Request request,
                          final Response response) {
        return "method3";
    }

}
