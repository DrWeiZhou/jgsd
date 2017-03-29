package edu.puxianxingyuan.jgsd.base.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@Scope("prototype")
public class Register {
	@RequestMapping("/reg")
	ModelAndView  regist(){
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.setViewName("/register");  
		return modelAndView;
	}
}
