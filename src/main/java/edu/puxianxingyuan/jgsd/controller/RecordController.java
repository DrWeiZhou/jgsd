package edu.puxianxingyuan.jgsd.controller;

import edu.puxianxingyuan.jgsd.domain.Record;
import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.RecordService;
import edu.puxianxingyuan.jgsd.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Controller
@Scope("prototype")
@RequestMapping("/record")
public class RecordController {

    @Resource
    UserService userService;

    @Resource
    RecordService recordService;

    @InitBinder("user")
    public void initBinder1(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("record")
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("record.");
    }

    @RequestMapping("/showAddRecord")
    ModelAndView showAddRecord() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/addRecord");
        return modelAndView;
    }

    @RequestMapping("/add")
    ModelAndView addRecord(@ModelAttribute User user, @ModelAttribute Record record, HttpSession session) {
        if(record.getDailyJgsdBZM() == null) record.setDailyJgsdBZM(0);
        if(record.getDailyJgsdXZ() == null) record.setDailyJgsdXZ(0);

        ModelAndView modelAndView = new ModelAndView();

        User dbUser = userService.isValidUser(user);
        if (dbUser != null) {
            session.setAttribute("user", dbUser);
            record.setUser(dbUser);
            recordService.saveRecord(record);
            modelAndView.setViewName("/successRecord");
        } else {
            modelAndView.setViewName("/errorRecord");
        }


        return modelAndView;
    }


    @RequestMapping("/getUserRecords")
    ModelAndView getUserRecords(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        User user = (User)session.getAttribute("user");
        if (user != null) {
            List<Record> userRecords = recordService.getUserRecords(user);
            modelAndView.getModel().put("userRecords",userRecords);
            modelAndView.setViewName("/userRecords");
        } else {
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping("/getTheDayRecords")
    ModelAndView getTheDayRecords(HttpSession session, HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        List<Record> theDayRecords = recordService.getTheDayRecords(new Date());
        modelAndView.getModel().put("theDayRecords",theDayRecords);
        modelAndView.setViewName("/theDayRecords");

        return modelAndView;
    }

    @RequestMapping("/getAllUserTotalRecords")
    ModelAndView getAllUserTotalRecords(HttpSession session, HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        List<Map> allUserTotalRecords = recordService.getAllUserTotalRecords();
        modelAndView.getModel().put("allUserTotalRecords",allUserTotalRecords);
        modelAndView.setViewName("/allUserTotalRecords");

        List<Record> theDayRecords = recordService.getTheDayRecords(new Date());
        modelAndView.getModel().put("theDayRecords",theDayRecords);

        return modelAndView;
    }



}
