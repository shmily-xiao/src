package com.demo;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * Created by simpletour_java on 2015/5/28.
 */
import java.awt.Window;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] arg){
        String tt = "sdhaihpiia";
        System.out.println(tt.charAt(2));
        int index = tt.offsetByCodePoints(2,3);
        int ii=0;
        int cp = tt.codePointAt(index);
        System.out.println(index);
        System.out.println(cp);
        System.out.println((char)cp);
        if(Character.isSupplementaryCodePoint(cp)){
            ii++;
        }
        Scanner in = new Scanner(System.in);
//        String name = in.nextLine();
        System.out.printf("%,+.2f", -5465465.0);
        System.out.println();
        int[] a = {4,5,6,6,7,9,10,2,5};
        Arrays a1;
        System.out.println(Arrays.toString(a));
        //Math.PI;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
//        int month = gregorianCalendar.get(Calendar.MONTH);
        System.out.println(new GregorianCalendar(1992,2,12,5,45,32));
        System.out.println(new Date());

        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        d.set(Calendar.DAY_OF_MONTH,1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = d.getFirstDayOfWeek();
        int indent = 0;
        while(weekday != firstDayOfWeek){
            indent ++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do{
            System.out.printf("%4s",weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }while(weekday != firstDayOfWeek);
        System.out.println();
        for(int i = 1;i<=indent; i++)
            System.out.print("    ");
        d.set(Calendar.DAY_OF_MONTH,1);
        do{
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if(day == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            d.add(Calendar.DAY_OF_WEEK,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            if(weekday == firstDayOfWeek)
                System.out.println();
        }while (d.get(Calendar.MONTH)==month);

        if(weekday != firstDayOfWeek)
            System.out.println();

        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        String t = new String("OK");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());

        System.out.println(Arrays.hashCode(a));
//        Logger.global.info("sjdaosjd");

        System.out.println( Integer.compare(2, 3));
        System.out.println( Integer.compare(3, 3));
        System.out.println( Integer.compare(3, 2));
        System.out.println(Double.compare(2.0,3.0));
        System.out.println(Double.compare(3.0,3.0));
        System.out.println(Double.compare(3.0,2.0));
    }

}