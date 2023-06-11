package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
SOLUTION

1:  Change your CrossOrigins annotation in your JAVA code to @CrossOrigins(origins = "http://localhost:3000", allowCredentials = "true")

2: Add  Origin header to your requests

'Origin': 'http://localhost:3000'
 */

@RestController
public class HelloWorldController {
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping(path = "/basicauth")
	public String checkAuthentication() {
		return "Success"; 
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World"; 
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World"); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name)); 
	}	
}
