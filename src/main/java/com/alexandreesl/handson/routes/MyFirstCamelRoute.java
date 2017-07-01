package com.alexandreesl.handson.routes;

import com.alexandreesl.handson.dto.AccessLogDTO;
import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexandrelourenco on 30/06/17.
 */

@Configuration
public class MyFirstCamelRoute extends SpringRouteBuilder {


    @Override
    public void configure() throws Exception {

        onException(Exception.class)
                .handled(false)
                .log(LoggingLevel.ERROR, "An Error processing the file!")
                .to("smtps://smtp.gmail.com:465?password=xxxxxxxxxxxxxxx&username=alexandreesl@gmail.com&subject=A error has occurred!");

        from("file:/Users/alexandrelourenco/Documents/apachecamelhandson?delay=1000&charset=utf-8&delete=true&moveFailed=.error")
                .setHeader("CamelAwsS3Key", header("CamelFileName"))
                .to("aws-s3:arn:aws:s3:::apache-camel-handson?amazonS3Client=#s3Client")
                .convertBodyTo(String.class)
                .split().tokenize("\n")
                    .convertBodyTo(AccessLogDTO.class)
                    .log(LoggingLevel.INFO, "${body}")
                    .to("aws-sqs://MyInputQueue?amazonSQSClient=#sqsClient");

    }
}
