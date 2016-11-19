package com.design.patterns.flyweight.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class Test {
    public static void main(String[] args) {
        // 工厂制造转发的规则
        WebSiteFactory factory = new WebSiteFactory();

        // 用户的请求中的一些关键字，来生成具体的网站实例
        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.use(new User("王明曦"));


        WebSite fx2 = factory.getWebSiteCategory("blog");
        fx2.use(new User("shmily"));

        System.out.println(factory.getWebSiteCount());

    }
}
