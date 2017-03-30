package edu.puxianxingyuan.jgsd.controller;

import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class Register {

    @Resource
    UserService userService;

	@RequestMapping("/reg")
	ModelAndView  regist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/register");
		return modelAndView;
	}

    @InitBinder("user")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @RequestMapping("/add")
	ModelAndView addUser(@ModelAttribute User user){
        userService.save(user);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		return modelAndView;
	}
}
