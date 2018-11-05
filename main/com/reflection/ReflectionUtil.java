package com.reflection;

import com.clone.Car;
import com.clone.Person;
import com.thread.Account;
import jdk.nashorn.internal.runtime.ECMAException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.file.Files;

/**
 * Created by simpletour_Jenkin on 2016/11/5.
 * 通过反射的方法去设置对象的私有变量的值
 * 反射工具类
 */
public class ReflectionUtil {

    public static void main(String[] args) {
        try {
            // 获得一个类的对象并且创建这个对象
            Account account = (Account) Class.forName("com.thread.Account").newInstance();
            // 获取一个类的对象并且通过构造方法创建这个对象
//            Account account2 = (Account)Class.forName("com.thread.Account").getConstructor().newInstance(2.5);
//            String s = String.class.getConstructor(String.class).newInstance("sss");
            Person person = (Person) Class.forName("com.clone.Person").getConstructor(Integer.class,Car.class,String.class).newInstance(12,new Car(),"sdsd");

        }catch (Exception e){
            e.printStackTrace();
        }

        Person person = new Person(45,new Car("auto",125),"sb");
        String name = (String) getValue(person,"car.brand");

        System.out.println(name);

    }

    private ReflectionUtil(){
        throw new AssertionError();
    }

    /**
     * 通过反射取对象指定字段（属性）的值
     * @param target     目标对象
     * @param fieldName  字段的名字
     * @throws RuntimeException 如果取不到对象指定的字段的值则抛出异常
     * @return           字段的值
     */
    public static Object getValue(Object target, String fieldName){
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");  // 用“.”分割，是为了嵌套的查询 比如 car.brand

        try{

            for (int i = 0; i < fs.length-1; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }
            Field field = clazz.getDeclaredField(fs[fs.length - 1]);
            field.setAccessible(true);
            return field.get(target);

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 通过反射给对象的指定字段赋值
     * @param target      目标对象
     * @param fieldName   字段的名称
     * @param value       值
     */
    public static void setValue(Object target, String fieldName, Object value){
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        try{
            for (int i = 0; i < fs.length-1; i++){
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                if (val == null){
                    Constructor<?> c = f.getType().getDeclaredConstructor();
                    c.setAccessible(true);
                    val = c.newInstance();
                    f.set(target, val);
                }
                target = val;
                clazz = target.getClass();
            }

            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            f.set(target,value);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
