package com.string;

public class TestJsonString {

    public String a;
    public int b;
    public String c="0";

    public TestJsonString(){}

    public TestJsonString(String a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString(){
        return "{a:"+this.a +" b:"+this.b + " c:" +this.c +"}";
    }

}
