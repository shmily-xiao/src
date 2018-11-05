package com.rxjava;

import java.util.function.Function;

/**
 * Created by simpletour_Jenkin on 2016/10/25.
 */
public class RxJava {

    interface Functor<T,F extends Functor<?,?>>{
        <R> F map(Function<T,R> f);
    }
    class Identity<T> implements Functor<T,Identity<?>>{
        private final T value;

        Identity(T value){
            this.value = value;
        }

        @Override
        public <R> Identity map(Function<T, R> f) {
            final R result = f.apply(value);
            return new Identity<>(result);
        }
    }

    Identity<String> identity = new Identity<>("nihao");

    public Identity<String> getIdentity() {
        return  identity.map(d -> d.toUpperCase());
    }

}
