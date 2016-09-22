package com.design.patterns.publish.subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/9/8.
 *
 * 老板作为通知者
 *
 */
public class Boss implements Subject{

    private List<Observer> observers = new ArrayList<>();

    private String action;

    private String subjectStatus;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update());
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public String getSubjectStatus() {
        return subjectStatus;
    }

    @Override
    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }
}
