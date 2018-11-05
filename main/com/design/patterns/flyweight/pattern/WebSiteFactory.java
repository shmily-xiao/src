package com.design.patterns.flyweight.pattern;

import java.util.Hashtable;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class WebSiteFactory {
    // 线程安全的
    private Hashtable<String, ConcreteWebSite> flyweights = new Hashtable<>();

    public WebSite getWebSiteCategory(String key){
        if (!flyweights.containsKey(key)){
            flyweights.put(key,new ConcreteWebSite(key));
        }
        return flyweights.get(key);
    }

    public int getWebSiteCount(){
        return flyweights.size();
    }

}
