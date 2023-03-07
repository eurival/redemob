package br.com.redemob.rocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.redemob"})


public class RocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketApplication.class, args);
	}

}
