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
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}

	@RequestMapping("/reg")
	ModelAndView  regist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/register");
		return modelAndView;
	}

	@RequestMapping("/getLogin")
	ModelAndView  showLogin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/login");
		return modelAndView;
	}

	@RequestMapping("/login")
	ModelAndView login(@ModelAttribute User user, HttpSession session){
		ModelAndView modelAndView = new ModelAndView();

		if(user != null){
			User dbUser = userService.isValidUser(user);
			if(dbUser != null){
				session.setAttribute("user",dbUser);
				modelAndView.setViewName("/home");
			}
			else{
				modelAndView.setViewName("/error");
			}
		}else{
			modelAndView.setViewName("/error");
		}

		return modelAndView;
	}


    @RequestMapping("/add")
	ModelAndView addUser(@ModelAttribute User user){
        userService.save(user);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/success");
		return modelAndView;
	}
}
