package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class MvcTestController {

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index.jsp");
		return view;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(ModelAndView view) {
		view.setViewName("home.html");
		return view;
	}
}
