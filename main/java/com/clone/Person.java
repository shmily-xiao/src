package com.clone;

import java.io.Serializable;

/**
 * Created by simpletour_Jenkin on 2016/10/28.
 */
public class Person implements Serializable{

    private static final Long serialVersionUID = -9102017020286042305L;

    private String name;
    private int age;
    private Car car;

    public Person() {
    }

    public Person(int age, Car car, String name) {
        this.age = age;
        this.car = car;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
