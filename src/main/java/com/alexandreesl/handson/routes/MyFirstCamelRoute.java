package com.alexandreesl.handson.routes;

import com.alexandreesl.handson.dto.AccessLogDTO;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexandrelourenco on 30/06/17.
 */

@Configuration
public class MyFirstCamelRoute extends SpringRouteBuilder {


    @Override
    public void configure() throws Exception {

        from("file:/Users/alexandrelourenco/Documents/apachecamelhandson?delay=1000&charset=utf-8&delete=true")
                .setHeader("CamelAwsS3Key", header("CamelFileName"))
                .to("aws-s3:arn:aws:s3:::apache-camel-handson?amazonS3Client=#s3Client")
                .convertBodyTo(String.class)
                .split().tokenize("\n")
                .convertBodyTo(AccessLogDTO.class)
                .to("log:mylog");

    }
}
