package com.clone;

/**
 * Created by simpletour_Jenkin on 2016/10/28.
 */
public class CloneTest {
    public static void main(String[] args) {

        try {
            Person person = new Person(45, new Car("santana", 180), "sdfsd");
            Person person1 = MyUtil.clone(person); // 深度克隆

            person1.getCar().setBrand("BYD");
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了

            System.out.println(person.getCar().getBrand());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
