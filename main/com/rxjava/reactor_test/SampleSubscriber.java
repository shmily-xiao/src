package com.rxjava.reactor_test;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

public class SampleSubscriber<T> extends BaseSubscriber<T> {
    @Override
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("hookOnSubscribe is running");
        super.request(2);
        System.out.println("hookOnSubscribe is end");
    }

    @Override
    public void hookOnNext(T value){

        System.out.println("hookOnNext start");
        System.out.println(value);
        super.request(2);
        System.out.println("hookOnNext is end");
        //super.cancel();
    }

    @Override
    public void hookOnComplete(){
        System.out.println("hookOnComplete");
    }

    @Override
    public void hookFinally(SignalType type) {
        System.out.println("hookFinally");
    }




}
