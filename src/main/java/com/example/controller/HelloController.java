package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("hello") //url맵핑 /hello 라고 치면 이 메서드 호출 
	public String hello(Model model) {
		model.addAttribute("data", "hello");
		return "hello"; 	//resources 의 hello.html  호출 
	}
	
	@GetMapping("hello-mvc")		
	public String helloMvc(@RequestParam( "name")String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template"; 
	}
}
