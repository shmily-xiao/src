package com.demo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by simpletour_java on 2015/6/4.
 */
public class Test3 {
    public static void main(String[] args){
        Date now = new Date();
        Timestamp time = new Timestamp(now.getTime());
        Date now1 = new Date(time.getTime());
        System.out.println(now1.getTime());
        System.out.println(now.getTime()-now1.getTime());
        System.out.println(time.toString());
        System.out.println(System.currentTimeMillis());
    }
}
