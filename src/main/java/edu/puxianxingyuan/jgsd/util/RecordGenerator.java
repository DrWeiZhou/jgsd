package edu.puxianxingyuan.jgsd.util;

import edu.puxianxingyuan.jgsd.service.RecordService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.TimerTask;

/**
 * Created by 周炜 on 2017/3/31.
 */
public class RecordGenerator extends TimerTask{
    RecordService recordService;

    public RecordGenerator(ServletContext servletContext) {
        ServletContext app = servletContext;
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(app);
        this.recordService = ctx.getBean("recordService", RecordService.class);
    }

    @Override
    public void run() {
           recordService.generateTheDayRecords();

    }
}
