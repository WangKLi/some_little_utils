package com.java.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author WangLi
 * @create 2018-04-18
 **/

public class DateTest {
    public static void main(String[] args) {

        /**
         * 获取前一天日期
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DAY_OF_MONTH, -1);
        Date time = instance.getTime();
        String format1 = format.format(time);
        System.out.println(format1);
    }
}
