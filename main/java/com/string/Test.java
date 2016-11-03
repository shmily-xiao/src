package com.string;

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

    }
}
