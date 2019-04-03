package com.rxjava.reactor_test;

import reactor.core.publisher.Flux;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Flux_test {
    public static void main(String[] args) {

        Flux<String> just = Flux.just("foo", "bar", "foobar");

        List<String> strings = Arrays.asList("foo", "bar", "foobar");
        Flux<String> stringFlux = Flux.fromIterable(strings);

        just.subscribe(i -> System.out.println(i));

        System.out.println("--");

        Flux<Integer> integerFlux = Flux.range(1, 20)
            .map(i -> {
                if (i <= 3) { return i;}
                //throw new RuntimeException("Got to 4");
                return i;
            });

        //integerFlux.subscribe(i -> System.out.println(i), error -> {
        //    System.err.println("Error" + error);
        //    //throw new RuntimeException(error);
        //});

        System.out.println("----");

        integerFlux.subscribe(i -> System.out.println(i),
            error -> System.err.println("Error" + error),
            () -> System.out.println("Done"),
            sub -> sub.request(10)
        );
        System.out.println("----");

        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        //integerFlux.subscribe(ss);

        Flux.generate(
            () -> 0,
            (state, sink) -> {
                sink.next("3 x" + state + " = " + 3*state);
                if (state == 10) {sink.complete();}
                return state + 1;
            }).subscribe( i -> System.out.println(i));

        Flux<Object> generate = Flux.generate(
            AtomicLong::new,
            (state, sink) -> {
                long i = state.getAndIncrement();
                sink.next("3 X " + i + " = " + 3 * i);
                if (i == 10) {sink.complete();}
                return state;
            }
        );
        generate.subscribe(i -> System.out.println(i));

        Flux.generate(
            AtomicLong::new,
            (state, sink) -> {
                long i = state.getAndIncrement();
                sink.next("3 X " + i + " = " + 3 * i);
                if (i == 10) {sink.complete();}
                return state;
            },
            (state) -> System.out.println("state = " + state)
        ).subscribe(i -> System.out.println(i));

    }

}


