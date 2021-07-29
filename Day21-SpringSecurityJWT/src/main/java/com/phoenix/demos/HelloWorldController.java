package com.phoenix.demos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String display()
	{
		return "Secure App";
	}
	
}
