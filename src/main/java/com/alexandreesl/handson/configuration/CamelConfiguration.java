package com.alexandreesl.handson.configuration;

import com.alexandreesl.handson.converters.StringToAccessLogDTOConverter;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {


    @Bean
    public CamelContextConfiguration camelContextConfiguration() {

        return new CamelContextConfiguration() {

            @Override
            public void beforeApplicationStart(CamelContext camelContext) {

                camelContext.getTypeConverterRegistry().addTypeConverters(new StringToAccessLogDTOConverter());

            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {

            }

        };

    }

}
