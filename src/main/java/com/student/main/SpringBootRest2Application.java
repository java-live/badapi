package com.student.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import software.amazon.codeguruprofilerjavaagent.Profiler;

@SpringBootApplication(scanBasePackages = { "com.student" })
public class SpringBootRest2Application {

	public static void main(String[] args) {

		new Profiler.Builder().profilingGroupName("studentapi").build().start();

		SpringApplication.run(SpringBootRest2Application.class, args);

	}
}
