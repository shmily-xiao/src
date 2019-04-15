package com.rxjava.reactor_test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.string.TestJsonString;
import jdk.dynalink.beans.StaticClass;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.awt.desktop.ScreenSleepEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Flux_test {
    public static void main(String[] args) throws Exception{

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

        System.out.println("------");

        Flux<String> handle = Flux.just(-1, 30, 13, 9, 20)
            .handle((i, sink) -> {
                String letter = alphabet(i);
                if (letter != null) {sink.next(letter);}
            });
        handle.subscribe(System.out::println);


        final Mono<String> mono = Mono.just("hello ");
        new Thread(() -> mono
        .map(msg -> msg + " thread ")
            .map( msg -> msg + " @@@@@ " + Thread.currentThread().getName() + " | ")
        .subscribe(v -> System.out.println(v + Thread.currentThread().getName()))
        ).start();

        // 一直循环的答应数据子
        //Flux.interval(Duration.ofMillis(1000), Schedulers.newParallel("test")).subscribe(System.out::println);

        Scheduler scheduler = Schedulers.newParallel("parallel - scheduler", 4);
        final Flux<String> flux = Flux
            .range(1,9)
            .map(i -> 10+i + " ** " + Thread.currentThread().getName() + "***")
            .subscribeOn(scheduler)
            //.publishOn(scheduler)
            .map(i -> "value "+i + " -- " + Thread.currentThread().getName());

        new Thread(() -> flux.subscribe(System.out::println));

        Flux.just(1, 2, 0)
            .map(i -> "Wow : " +  100 /i )
            .onErrorReturn("DIvided by zero : (")
            .subscribe(System.out::println);

        Flux.<String>error(new IllegalArgumentException())
            .doOnError(System.out::println)
            .retryWhen(companion -> companion.zipWith(
                Flux.range(1, 4),
                (error, index) -> {
                    if (index < 3) {return index;}
                    else {throw Exceptions.propagate(error);}
                }
            ))
            .subscribe(System.out::println);
        StringBuilder sb =new StringBuilder();
        Set<String> strings1 = Set.of("22", "11", "333");
        Flux.just(strings1.toArray()).reduce((a,b)-> a+","+b).subscribe( item -> sb.append(item));
        System.out.println(sb.toString());



        String jsonString = "{\"a\":\"qdcscs\",\"b\":3, \"c\":\"233\"}";
        //TestJsonString testJsonString = JSONObject.parseObject(jsonString, TestJsonString.class);
        //System.out.println(testJsonString);
        Mono.just(jsonString)
            .map(item -> JSONObject.parseObject(jsonString, TestJsonString.class))
            .subscribe(item -> System.out.println(item));


        Object[] objects =new Object[4];
        //objects[0] = "sdfsdfds";
        //objects[1] = 1;
        //objects[2] = "3";
        objects[0] = new TestJsonString("SB",2,"333");
        System.out.println(JSONPath.eval(objects, "$[0].a"));

    }

    public static String alphabet(int letterNumber){
        if (letterNumber <1 || letterNumber > 26){
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }

}



