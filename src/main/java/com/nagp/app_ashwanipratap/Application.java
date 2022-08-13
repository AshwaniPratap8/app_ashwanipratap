package com.nagp.app_ashwanipratap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@RestController
class MessageController {
	@GetMapping("/message")
	public String getMessage() {
		return ("NAGP 2022 Technology Band III Batch");
	}
}
