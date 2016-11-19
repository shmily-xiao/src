package com.design.patterns.visitor.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 *
 * 打通元素和访问者之间的隔阂
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void attach(Element element){
        elements.add(element);
    }

    public void detach(Element element){
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        for (Element element : elements){
            element.accept(visitor);
        }
    }
}
