package edu.puxianxingyuan.jgsd.controller;

import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.RecordService;
import edu.puxianxingyuan.jgsd.util.DateUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@Scope("prototype")
public class HomeController {
	@Resource
	RecordService recordService;

	@RequestMapping("/home")
	ModelAndView  showHome(HttpSession session){
//		System.out.println("home is here!");
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)session.getAttribute("user");
		if(user != null) {
			Map<String,Integer> userTotalRecords = recordService.getUserTotalRecords(user);
			if(userTotalRecords != null){
				Integer totalBZM = userTotalRecords.get("totalBZM");
				Integer totalXZ = userTotalRecords.get("totalXZ");
				modelAndView.getModel().put("totalBZM",totalBZM);
				modelAndView.getModel().put("totalXZ",totalXZ);
			}

			modelAndView.getModel().put("today", new SimpleDateFormat("yyyy年MM月dd日").format(DateUtil.changeLocale(new Date())));
			modelAndView.getModel().put("remainDays",DateUtil.getRemainDays(new Date()));
			modelAndView.setViewName("homePage");

		}
		else {
			modelAndView.setViewName("/error");
		}
		return modelAndView;
	}
}
