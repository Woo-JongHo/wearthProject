package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("index")
	public void index() {
	}
	
	@GetMapping("opinion")
	public void list3() {
	}

	
	@GetMapping("school/trainingRequest/insert")
	public void insert() {
	}
	@GetMapping("school/trainingRequest/detail")
	public void detail2() {}
	@GetMapping("school/trainingRequest/detailAdmin")
	public void detail3() {}
	@GetMapping("school/trainingRequest/list")
	public void list4() {}
	@GetMapping("school/trainingRequest/update")
	public void update() {}
}
