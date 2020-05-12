package com.rxjava.reactor_test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author wangzaijun
 * @date 2020/05/12
 */
public class FutureChainDataLoader extends DataLoader{

    @Override
    protected void doLoad() {
        CompletableFuture
            .runAsync(super::loadConfigurations)
            .thenRunAsync(super::loadUsers)
            .thenRunAsync(super::loadOrders)
            .whenComplete((result, throwable) -> { // 完成时回调
                System.out.println("加载完成");
            })
            .join(); // 等待完成
    }
    public static void main(String[] args) {
        new FutureChainDataLoader().load();
    }

    @Override
    protected void doLoadV2(){
        Scheduler lll = Schedulers.newParallel("lll", 4);
        Mono.fromRunnable(() -> super.loadConfigurations())
            .publishOn(lll)
            .zipWith(Mono.fromRunnable(() -> super.loadUsers()).publishOn(lll))
            .zipWith(Mono.fromRunnable(() -> super.loadOrders()).publishOn(lll))
            .doOnSuccess(e -> System.out.println("加载完成"))
            .block();
    }
}
