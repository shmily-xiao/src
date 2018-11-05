package com.demo;

import sun.security.provider.MD5;

import java.util.Random;

/**
 * Created by simpletour_java on 2015/6/3.
 */
public class Test2 {
    public static void  main(String[] args){

        Random random = new Random();
        System.out.println(random.doubles().toString());
        System.out.println(((Math.random()*100+1)*1000));
        System.out.println(((Math.random()*100+1)*1000)-1);
        System.out.println((int)(((Math.random()*100+1)*1000)-1));
        int pwd = ("iahwiw65eir" + (int)(((Math.random()*100+1)*1000)-1)).hashCode();
        System.out.println(pwd);
        String pp = messageDigest("123456789");
        System.out.println(pp.length());

//        1032802048
    }
    //生成MD5摘要的算法
    public static String messageDigest(String text) {
        String temp="";

        try {

            java.security.MessageDigest alga=java.security.MessageDigest.getInstance("MD5");
            alga.update(text.getBytes());
            byte[] aDigest=alga.digest();
            temp = byte2hex(aDigest); //将字符串转换成二进制
            return temp;
        }
        catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("非法摘要算法");
        }
        return temp;
    }

    // 二行制转字符串，生成摘要的时候用到了这个
    private static String byte2hex(byte[] b)
    {
        String hs="";
        String temp="";
        for (int n=0;n<b.length;n++)
        {
            temp=(java.lang.Integer.toHexString(b[n] & 0XFF)); //这里是将字符串转换成16进制的字符
            if (temp.length()==1) hs=hs+"0"+temp;
            else hs=hs+temp;
            if (n<b.length-1)  hs=hs+"";
        }
        return hs.toUpperCase();
    }

}
