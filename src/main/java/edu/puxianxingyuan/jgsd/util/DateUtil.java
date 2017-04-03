package edu.puxianxingyuan.jgsd.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 周炜 on 2017/3/30.
 */
public class DateUtil {
    public static Date getTheDate(Date oriDate) {//获得记录对应的修行日期

        Calendar theDay = Calendar.getInstance();
        theDay.setTime(oriDate);

//        System.out.println(theDay.get(Calendar.DAY_OF_MONTH));

        int nowHour = theDay.get(Calendar.HOUR_OF_DAY);
        if (nowHour < 12) {//如果当日12点以前报，则表示是昨天修行的记录
            theDay.add(theDay.DATE, -1);
        }

        //设置成0点0分0秒
        theDay.set(Calendar.HOUR_OF_DAY, 0);
        theDay.set(Calendar.MINUTE, 0);
        theDay.set(Calendar.SECOND, 0);


//        System.out.println(theDay.get(Calendar.DAY_OF_MONTH));
        return theDay.getTime();
    }

    public static boolean isSameDay(Date oneDate, Date twoDate){
        boolean rst = false;
        Calendar oneCal = Calendar.getInstance();
        oneCal.setTime(oneDate);

        Calendar twoCal = Calendar.getInstance();
        oneCal.setTime(twoDate);

        if(oneCal.getTimeInMillis() == twoCal.getTimeInMillis()){
            rst = true;
        }

        return rst;
    }

    static public Date changeLocale(Date date){//新加坡服务器比中国早8个小时，此方法返回表示业务时间的中国时间
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.HOUR_OF_DAY ,8);
        return c.getTime();
    }
    static public Date changeToSystem(Date date){//新加坡服务器比中国早8个小时，此方法返回表示实际的机器时间
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.HOUR_OF_DAY ,-8);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getTheDate(new Date()));
    }

    public static Date getYesterDate(Date date) {
        Date theDay = getTheDate(date);

        Calendar c = Calendar.getInstance();
        c.setTime(theDay);
        c.add(c.DATE, -1);

        Date yesterDate = c.getTime();

        return yesterDate;
    }

    public static long getTomorrowGeneratedTime() {//获得当前时间到明天中午12点1分的毫秒数
        long rst = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.changeLocale(new Date()));
        c.add(c.DATE, +1);
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 1);
        c.set(Calendar.SECOND, 0);


        return c.getTimeInMillis() - DateUtil.changeLocale(new Date()).getTime();
    }

    public static Date getNextGeneratedDate() {
        Date rst = null;

        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.changeLocale(new Date()));

        int nowHour = c.get(Calendar.HOUR_OF_DAY);
        if (nowHour < 12) {//如果现在在12点之前，则下次生成的时间为当日的12点1分
            c.set(Calendar.HOUR_OF_DAY, 12);
            c.set(Calendar.MINUTE, 1);
            c.set(Calendar.SECOND, 0);
        }else{//如果现在在12点之后，则下次生成的时间为明日的12点1分
            c.add(c.DATE, +1);
            c.set(Calendar.HOUR_OF_DAY, 12);
            c.set(Calendar.MINUTE, 1);
            c.set(Calendar.SECOND, 0);
        }

        System.out.println("---------下次预计生成的业务时间为："+c.getTime());
        System.out.println("---------下次预计生成的实际系统时间为："+changeToSystem(c.getTime()));
        return changeToSystem(c.getTime());
    }

    public static Integer getRemainDays(Date date) {
        Integer rst = -1;

        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.changeLocale(new Date()));
        c.set(Calendar.YEAR, 2017);
        c.set(Calendar.MONTH, 5);//6月
        c.set(Calendar.DAY_OF_MONTH, 31);

        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);


        return (int)((c.getTimeInMillis()-date.getTime())/(1000*60*60*24));
    }
}
