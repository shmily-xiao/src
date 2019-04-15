package com.rxjava.reactor_test;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class PublisherTest {

    public Flux<String> processOrFallback(Mono<String> source, Publisher<String> fallback) {
        return source
            .flatMapMany(phrase -> Flux.fromArray(phrase.split("\\s+")))
            .switchIfEmpty(fallback);
    }

    public void testSplitPathIsUsed(){
        StepVerifier.create(this.processOrFallback(Mono.just("just a phrase"), Mono.just("EMPTY_PHRASE")))
            .expectNext("just", "a", "phrase")
            .verifyComplete();
    }

    public void testEmptyPathIsUsed(){
        StepVerifier.create(this.processOrFallback(Mono.empty(), Mono.just("EMPTY_PHRASE")))
            .expectNext("EMPTY_PHRASE")
            .verifyComplete();
    }


}
