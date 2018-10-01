package com.julianosena.poc.spring.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.Serializable;

@SpringBootApplication
@EnableBinding(Sink.class)
public class RabbitmqSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSpringCloudStreamApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(Product person) {
		System.out.println("Received: " + person);
	}

	public static class Product implements Serializable {

		private static final long serialVersionUID = -6299676120578395685L;

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}
	}
}
