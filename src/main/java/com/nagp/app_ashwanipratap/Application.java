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
		return ("<b>NAGP 2022 Technology Band III Batch</b><br>" +
				"Environment Variables from ConfigMap<br>" +
				"--------------------------------------------------------<br>" +
				"url: " + System.getenv("url") + "<br>" +
				"environment: " + System.getenv("env") + "<br>"+
				"Environment Variables from Secret(After decoding)<br>" +
				"--------------------------------------------------------<br>" +
				"DB_PASSWORD: " + System.getenv("DB_PASSWORD") + "<br>" +
				"FB_PASSWORD: " + System.getenv("FB_PASSWORD") + "<br>");

	}

	@GetMapping("/testmessage")
	public String getTestMessage() {
		return ("NAGP 2022 Technology Band III Batch");
	}
}
