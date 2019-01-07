package com.rxjava.myPublisher;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        MyPublisher publisher = new MyPublisher();

        MySubscriber subscriberA = new MySubscriber("A");
        MySubscriber subscriberB = new MySubscriber("B");

        publisher.subscribe(subscriberA);
        publisher.subscribe(subscriberB);

        publisher.waitUntilTerminated();

        // 运行的结果
        // Subscriber A >> [main] Subscribed
        // Subscriber A >> [main] Requesting 3 new items...
        // Subscriber B >> [main] Subscribed
        // Subscriber B >> [main] Requesting 3 new items...
        // Publisher >> [pool-1-thread-2] publish item: [2] ... A
        // Publisher >> [pool-1-thread-1] publish item: [1] ... A
        // Publisher >> [pool-1-thread-3] publish item: [3] ... A
        // Publisher >> [pool-1-thread-4] publish item: [1] ... B
        // Subscriber A >> [pool-1-thread-1] 1
        // Subscriber A >> [pool-1-thread-2] 2
        // Subscriber A >> [pool-1-thread-3] 3
        // Subscriber B >> [pool-1-thread-4] 1
        // Publisher >> [pool-1-thread-1] publish item: [2] ... B
        // Publisher >> [pool-1-thread-2] publish item: [3] ... B
        // Subscriber A >> [pool-1-thread-3] Cancelling subscription...
        // Subscriber B >> [pool-1-thread-1] 2
        // Subscriber B >> [pool-1-thread-2] 3
        // Subscriber B >> [pool-1-thread-2] Requesting 3 new items...
        // Publisher >> [pool-1-thread-2] publish item: [4] ... B
        // Publisher >> [pool-1-thread-3] publish item: [6] ... B
        // Publisher >> [pool-1-thread-4] publish item: [5] ... B
        // Subscriber B >> [pool-1-thread-2] 4
        // Subscriber B >> [pool-1-thread-3] 6
        // Subscriber B >> [pool-1-thread-4] 5
        // Subscriber B >> [pool-1-thread-4] Requesting 3 new items...
        // Publisher >> [pool-1-thread-1] publish item: [7] ... B
        // Publisher >> [pool-1-thread-2] publish item: [9] ... B
        // Subscriber B >> [pool-1-thread-1] 7
        // Publisher >> [pool-1-thread-4] publish item: [8] ... B
        // Subscriber B >> [pool-1-thread-2] 9
        // Subscriber B >> [pool-1-thread-4] 8
        // Subscriber B >> [pool-1-thread-4] Cancelling subscription...
        // Publisher >> [pool-1-thread-4] Shut down executor...
        // Publisher >> [pool-2-thread-1] Shutdown complete.

        // 分析
        // main 启动了两个订阅 Subscriber A 、Subscriber B
        // 然后 线程A 和 线程B 同时生成 消息
        // 异步生成
        // 之后 SubscriberA和SubscriberB 开始消费/处理 data
        // SubscriberA处理完成之后 随机的选择取消订阅或者是继续request 数据，这里A随机到了取消操作
        // SubscriberB随机到了继续 request 数据
        // 之后SubscriberB 也随机到了取消订阅操作
    }


}
