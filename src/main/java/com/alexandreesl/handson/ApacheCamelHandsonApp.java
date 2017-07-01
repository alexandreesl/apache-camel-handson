package com.alexandreesl.handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by alexandrelourenco on 28/06/17.
 */

@ComponentScan(basePackages = {"com.alexandreesl.handson"})
@SpringBootApplication
@EnableAutoConfiguration
public class ApacheCamelHandsonApp {

    public static void main(String[] args) {
        SpringApplication.run(ApacheCamelHandsonApp.class, args);
    }

}
