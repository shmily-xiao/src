package com.design.patterns.publish.subscribe;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 */
public class NBAObserver extends Observer{

    public NBAObserver(String name, Subject sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getSubjectStatus() + "," + name + "nba好看么？");
    }
}
