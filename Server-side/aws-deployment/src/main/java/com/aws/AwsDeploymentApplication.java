package com.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwsDeploymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDeploymentApplication.class, args);
	}

	@GetMapping("/")
	public String Hello() {
		return "Hello, This is your app for deploying in the EC2 server";
	}

}
