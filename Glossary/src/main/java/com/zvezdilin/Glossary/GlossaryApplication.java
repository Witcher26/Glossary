package com.zvezdilin.Glossary;


import com.zvezdilin.Glossary.api.AdminController;
import com.zvezdilin.Glossary.api.DatabaseController;
import com.zvezdilin.Glossary.engine.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zvezdilin.Glossary")
public class GlossaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlossaryApplication.class, args);
        DatabaseController controller = new DatabaseController();
        AdminController admin = AdminController.getAdmin();
        Engine engine = new Engine();
    }
}
