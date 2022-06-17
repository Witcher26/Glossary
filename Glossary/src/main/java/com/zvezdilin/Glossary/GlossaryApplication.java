package com.zvezdilin.Glossary;

import com.zvezdilin.Glossary.database.DatabaseAdapter;
import com.zvezdilin.Glossary.model.entity.English;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlossaryApplication {

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(GlossaryApplication.class, args);
	}
}
