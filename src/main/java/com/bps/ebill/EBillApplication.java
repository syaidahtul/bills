package com.bps.ebill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBillApplication.class, args);
	}

	/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.bps.ebill.models.Categories;
import com.bps.ebill.repository.CategoryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			categoryRepository.save(new Categories("TNT","Tuntutan", true));
			categoryRepository.save(new Categories("SKT","Syarikat", true));
		};
	}
	*/
}
