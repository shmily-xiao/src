package com.design.patterns.flyweight.pattern;

/**
 * Created by simpletour_Jenkin on 2016/11/19.
 */
public class ConcreteWebSite implements WebSite {
    private String webSiteName;

    public ConcreteWebSite() {
    }

    public ConcreteWebSite(String webSiteName) {
        this.webSiteName = webSiteName;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + webSiteName + " 用户： " + user.getName());
    }
}
