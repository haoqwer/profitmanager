package com.chenyou.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        String[] add = {"1001", "1002"};
        String channelId = "";

        System.out.println(channelId);
        String[] channelIds = channelId.split(",");
        System.out.println(Arrays.toString(channelIds));
    }
}
