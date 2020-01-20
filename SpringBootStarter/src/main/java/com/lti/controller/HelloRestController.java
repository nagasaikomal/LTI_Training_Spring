package com.lti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="HelloApp")
public class HelloRestController {
	// http://localhost:9090/HelloApp/hello
	// method: get
	@RequestMapping(path="hello", method=RequestMethod.GET)
	public String hello1(){
		return "Hello from Rest Controller : get krishna";
	}
	
	// http://localhost:9090/HelloApp/hello
	// method: post
	@RequestMapping(path="hello", method=RequestMethod.POST)
	public String hello2(){
		return "Hello from Rest Controller : post krishna";
	}
}
