package com.sarp.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sarp.data.domain.Book;
import com.sarp.data.domain.BookRepository;

@SpringBootApplication
public class DataUnitApplication {
	
	private Logger logger = LoggerFactory.getLogger(DataUnitApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataUnitApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(BookRepository bookRepository){
		return args -> {
			bookRepository.save(new Book("Elvada Guzel Vatanim","Ahmet Umit"));
			logger.info("working with commandline runner bean");
		};
	}
}
