package com.hanul.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/first")
	public String aaaaa(Model model) {
		model.addAttribute("today", "2021�� 1�� 4��");
		
		return "view";
	}
}
