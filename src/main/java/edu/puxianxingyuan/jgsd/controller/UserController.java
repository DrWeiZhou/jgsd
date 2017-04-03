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
import java.io.Serializable;
import java.util.List;

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
    ModelAndView regist() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/register");
        return modelAndView;
    }

    @RequestMapping("/showLogin")
    ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @RequestMapping("/getModify")
    ModelAndView showModify() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/register");
        modelAndView.getModel().put("type", "modify");
        return modelAndView;
    }

    @RequestMapping("/login")
    ModelAndView login(@ModelAttribute User user, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        if (user != null) {
            User dbUser = userService.isValidUser(user);
            if (dbUser != null) {
                session.setAttribute("user", dbUser);
                modelAndView.setViewName("forward:/home");
            } else {
                modelAndView.setViewName("/error");
            }
        } else {
            modelAndView.setViewName("/error");
        }

        return modelAndView;
    }


    @RequestMapping("/add")
    ModelAndView addUser(@ModelAttribute User user, HttpSession session) {
        if (user.getDailyJgsdBZM() == null) user.setDailyJgsdBZM(0);
        if (user.getDailyJgsdXZ() == null) user.setDailyJgsdXZ(0);

        ModelAndView modelAndView = new ModelAndView();
        if (user.getUserName() == null || user.getUserName().trim().equals("")) {
            modelAndView.setViewName("/errorReg");
        } else {
            boolean exist = userService.isSameUserName(user);
            if (exist) {
                modelAndView.setViewName("/errorReg");
            } else {

                Serializable id = userService.save(user);

                User dbUser = userService.getById(id);
                if (dbUser != null) {
                    session.setAttribute("user", dbUser);
                }
                modelAndView.setViewName("/successReg");
            }
        }

        return modelAndView;
    }

    @RequestMapping("/modify")
    ModelAndView modifyUser(@ModelAttribute User user, HttpSession session) {
        userService.updateByDTO(user);

        User dbUser = userService.getById(user.getUserId());
        if (dbUser != null) {
            session.setAttribute("user", dbUser);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/successModify");
        return modelAndView;
    }

    @RequestMapping("/findAllUsers")
    ModelAndView findAllUsers() {
        List<User> allUsers = userService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("users", allUsers);
        modelAndView.setViewName("/userList");
        return modelAndView;
    }

    @RequestMapping("/delete")
    ModelAndView deleteUser(HttpSession session) {
        User user = (User) session.getAttribute("user");

        userService.deleteById(user.getUserId());
        session.removeAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/comeon");
        return modelAndView;
    }

}
