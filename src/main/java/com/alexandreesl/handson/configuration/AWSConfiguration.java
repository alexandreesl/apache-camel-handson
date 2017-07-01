package com.alexandreesl.handson.configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AWSConfiguration {


    @Autowired
    private Environment environment;

    @Bean(name = "s3Client")
    public AmazonS3Client s3Client() {
        return new AmazonS3Client(staticCredentialsProvider()).withRegion(Regions.fromName("us-east-1"));
    }

    @Bean(name = "sqsClient")
    public AmazonSQSClient sqsClient() {
        return new AmazonSQSClient(staticCredentialsProvider()).withRegion(Regions.fromName("us-east-1"));
    }

    @Bean
    public StaticCredentialsProvider staticCredentialsProvider() {
        return new StaticCredentialsProvider(new BasicAWSCredentials("<access key>", "<secret access key>"));
    }

}
