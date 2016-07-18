package com.design.patterns.decoratepattern.demo;

/**
 * Created by simpletour_Jenkin on 2016/7/18.
 */
public abstract class Decorator extends Component{
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        if (this.component != null){
            this.component.Operation();
        }
    }
}
