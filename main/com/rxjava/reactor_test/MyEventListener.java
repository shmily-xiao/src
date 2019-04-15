package com.rxjava.reactor_test;


import java.util.List;

public interface MyEventListener<T> {
    void onDataChunk(List<T> chunk);

    void processComplete();



}
