package com.mlk;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@RequestMapping("/submitResult")
	public String getResult() {
		return "result";
	}
	
	@RequestMapping("/submitResultWithModel")
	public String getResultWithModel(HttpServletRequest request, Model model) {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		String result = login + "  " + password;
		
		model.addAttribute("result", result);
		
		System.out.println("model : " + model);
		System.out.println("result : " + result);
		
		return "result";
	}
}
