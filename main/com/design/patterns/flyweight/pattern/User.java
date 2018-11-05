package com.design.patterns.flyweight.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
