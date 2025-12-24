package io.aviraj.multimodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.aviraj.multimodel.config.ModelProperties;

@SpringBootApplication
@EnableConfigurationProperties(ModelProperties.class)
public class MultiModelAiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiModelAiApplication.class, args);
    }
}
