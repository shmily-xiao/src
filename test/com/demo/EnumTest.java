package com.demo;

import java.util.Scanner;

/**
 * Created by simpletour_java on 2015/6/1.
 */
public class EnumTest {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("enter a size :(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size= "+size);
        System.out.println("abbreviation = "+size.getAbbreviation());
        if(size == Size.EXTRA_LARGE){
            System.out.println("Good job--you paid attention to the _.");
        }
    }
    enum Size{
        SMALL("S"),MESIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

        private Size(String abbreviation){
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation(){
            return abbreviation;
        }
        private String abbreviation;
    }
}
