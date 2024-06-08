package com.example.effectivejava.chapter3.autovalue;

import com.google.auto.value.*;

@AutoValue
abstract public class Point {
//    static Point create(int x, int y) {
//        return new AutoValue_Point(x, y);
//    }

    abstract int x();
    abstract int y();
}
