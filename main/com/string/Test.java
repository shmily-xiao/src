package com.string;

import java.util.Collection;

/**
 * Created by simpletour_Jenkin on 2016/11/3.
 */
public class Test {
    public static void main(String[] args) {
        String ss = "abcd";
        String aa = "abcdabcdacbdaaddabcd";
        int count =0;
        while(aa.length() >= ss.length() && aa.contains(ss)){
            count ++;
            aa = aa.substring(aa.indexOf(ss)+ss.length());
        }
        System.out.println(count);


//        for (int y = 1; y <= 2250/29;y++){
//            for (int x = 1 ;x <= 2250/53;x++){
//                if (53*x+29*y == 2250){
//                    System.out.println("x=" + x+",y="+y);
//                }
//            }
//        }
    }
}
