package edu.puxianxingyuan.jgsd.util.listener;

import edu.puxianxingyuan.jgsd.service.GeneratedRecordService;
import edu.puxianxingyuan.jgsd.service.RecordService;
import edu.puxianxingyuan.jgsd.util.DateUtil;
import edu.puxianxingyuan.jgsd.util.RecordGenerator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

public class TimerInitListener implements ServletContextListener  {
	private Timer timer = null;  

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel(); 
		event.getServletContext().log("定时器销毁");  
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("-----------------listener startup success!");
		 //在这里初始化监听器，在tomcat启动的时候监听器启动，可以在这里实现定时器功能 
		  timer = new Timer(true); 
		  event.getServletContext().log("定时器已启动");//添加日志，可在tomcat日志中查看到

		ServletContext app = event.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(app);
		GeneratedRecordService grs = ctx.getBean("generatedRecordService", GeneratedRecordService.class);
		if(grs.isYesterdayGenerated()){//已经自动生成,设置下次生成时间
//			System.out.println("----------昨天已经自动生成！");
			timer.schedule(new RecordGenerator(event.getServletContext()), DateUtil.getNextGeneratedDate(),24*60*60*1000);
		}else{//没有自动生成，则立刻执行生成，设置下次生成时间
//			System.out.println("----------昨天还未自动生成！");
			RecordService rs = ctx.getBean("recordService", RecordService.class);
			rs.generateTheDayRecords();
			timer.schedule(new RecordGenerator(event.getServletContext()), DateUtil.getNextGeneratedDate(),24*60*60*1000);
		}

		    //调用exportHistoryBean，0表示任务无延迟，5*1000表示每隔5秒执行任务，表示一个小时；

	}

}
