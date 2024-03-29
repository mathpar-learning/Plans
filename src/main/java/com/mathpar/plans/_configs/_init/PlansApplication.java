package com.mathpar.plans._configs._init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.mathpar.plans.*"})
public class PlansApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlansApplication.class, args);
    }

}
