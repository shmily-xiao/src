package com.projectreactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Flux.just("Hello world!")
            .map(it -> it.split(""))
            .flatMap(Flux::fromArray)
            .zipWith(Flux.range(1,1000), (str, count) -> count + str)
            .subscribe(System.out::println);

        long s = System.currentTimeMillis();
        Flux.interval(Duration.ofSeconds(1)).take(7200).then();
        long e = System.currentTimeMillis();

        System.out.println(e-s);

        SubmissionPublisher<Long> publisher = new SubmissionPublisher<>();
        CompletableFuture<Void> consume = publisher.consume(System.out::println);
        LongStream.range(0, 1000).forEach(publisher::submit);

    }
}
