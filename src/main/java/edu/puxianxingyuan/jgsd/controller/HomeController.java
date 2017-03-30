package edu.puxianxingyuan.jgsd.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
public class HomeController {

	@RequestMapping("/home")
	ModelAndView  showHome(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("user") != null)
			modelAndView.setViewName("/home");
		else
			modelAndView.setViewName("/error");

		return modelAndView;
	}
}
