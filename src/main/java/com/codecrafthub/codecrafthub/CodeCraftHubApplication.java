package com.codecrafthub.codecrafthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.codecrafthub.codecrafthub", "com.codecrafthub.CourseController", "com.codecrafthub.service", "com.codecrafthub.model"})
public class CodeCraftHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeCraftHubApplication.class, args);
    }

}