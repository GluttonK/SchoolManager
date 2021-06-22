package com.demo.schoolmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.schoolmanager.*"})
public class SchoolmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolmanagerApplication.class, args);
    }

}
