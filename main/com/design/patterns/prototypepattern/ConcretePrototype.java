package com.design.patterns.prototypepattern;

/**
 * Created by simpletour_Jenkin on 2016/7/21.
 */
public class ConcretePrototype extends Prototype{

    public ConcretePrototype(String id){
        super(id);
    }


    @Override
    public Prototype Clone() {
//        return (Prototype) this.MemberWiseClone();
        Prototype prototype;
        try{
            prototype = (Prototype) this.clone();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return prototype;
    }

}
