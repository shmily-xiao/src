package com.design.patterns.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/11/16.
 *
 * 创建被迭代的对象的数据
 *
 */
public class MyAggregateImpl implements Aggregate {

    private List<Object> items = new ArrayList<>();


    @Override
    public Iterator createIterator() {
        return new MyIteratorImpl(this);
    }

    public int getCount(){
        return items.size();
    }

    public void setItem(int index, Object value){
        items.add(index,value);
    }

    public Object getItem(int index){
        return items.get(index);
    }
}
