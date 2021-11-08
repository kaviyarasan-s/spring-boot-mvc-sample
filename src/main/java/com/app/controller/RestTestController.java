package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class RestTestController {
	
	@GetMapping("/")
	public String test() {
		return "Running!!!";
	}

}
