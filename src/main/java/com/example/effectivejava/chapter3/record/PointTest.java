package com.example.effectivejava.chapter3.record;

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(1, 0);
        System.out.println(p1.equals(p2));
        System.out.println(p1);
        System.out.println(p1.x());
    }
}
