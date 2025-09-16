package com.stackroute.sampleeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SampleeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleeurekaApplication.class, args);
	}

}
