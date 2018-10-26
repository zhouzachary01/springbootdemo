package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
class Demo1Application extends SpringBootServletInitializer {

	@RequestMapping("/admin")
	public String index1(){

		return "login/login";
	}

	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(Demo1Application.class, args);
	}
}
