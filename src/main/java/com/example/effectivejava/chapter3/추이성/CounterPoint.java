package com.example.effectivejava.chapter3.추이성;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();
    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public static int numberCreated() {
        return counter.get();
    }
}
