package ru.HelImerr.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("ru.HelImerr.dictionary.model")
@EnableAutoConfiguration
public class DictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryApplication.class, args);
	}

}


