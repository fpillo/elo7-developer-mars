package com.elo7.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elo7.mars.domains.Mars;

@SpringBootApplication
public class MarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsApplication.class, args);
	}

	@Bean
	public Mars defaultMars() {
	    return new Mars(5, 5);
    }

}
