package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Value("${spring.application.name:demoservice}")
	private String name;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello world from Command Line Runner");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@RequestMapping(value = "/")
	public String name() {
		return name;
	}
}