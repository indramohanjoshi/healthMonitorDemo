package com.example.healthMonitorDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping(value = "/greeting")
	public String welcome() {
		LOG.debug("Greeting from HelloWorldController !");
		return "Hello -World!";
	}
}