package br.com.hybridinnovation.digitalcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DigitalcareapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalcareapiApplication.class, args);
	}

}
