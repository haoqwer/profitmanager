package com.chenyou.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.test
 * @ClassName: DateDemo
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 14:02
 * @Version: 1.0
 **/
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        System.out.println(sdf.format(date));
        System.out.println(date);
    }
}
