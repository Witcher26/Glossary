package com.zvezdilin.Glossary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zvezdilin.Glossary")
public class GlossaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlossaryApplication.class, args);
    }
}
