package com.zvezdilin.Glossary;

import com.zvezdilin.Glossary.model.engine.Engine;
import com.zvezdilin.Glossary.model.engine.TodosLanguageStorageConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlossaryApplication {

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(GlossaryApplication.class, args);
		TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();
		Engine engine = new Engine();
	}
}
