package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("hello-string")
	@ResponseBody		//http body(응답) 부분에 이 데이터를 직접 넣어주겠다 
	public String helloString(@RequestParam("name")String name) {
		return "hello"+ name; 	//Hello spring  
	}
	
	@GetMapping("hello-api")
	@ResponseBody													//responseBody 태그와 객체를 반환하면 기본적으로  Json으로 반환 (기본 셋팅) 
	public hello helloApi(@RequestParam("name")String name) {
		hello hello = new hello();
		hello.setName(name);										//Hello객체  
		return  hello;						//  was -> helloController -> @responseBody return hello(name:spring) -> HttpMessageConverter ( 객체면 JsonConverter작 ->	요청한 웹에 전 
	}
	 
	static class hello{
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name= name;
		}
	}
}
