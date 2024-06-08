package com.example.effectivejava.chapter3.추이성.composition;

import com.example.effectivejava.chapter3.추이성.Color;
import com.example.effectivejava.chapter3.추이성.Point;

import java.util.Set;

public class CounterPointTest {
    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0), new Point(0, 1),
            new Point(-1, 0), new Point(0, -1)
    );

    public static boolean onUnitCircle(Point point) {
        return unitCircle.contains(point);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new ColorPoint(1, 0, Color.RED).asPoint();

        System.out.println(onUnitCircle(p1));
        System.out.println(onUnitCircle(p2));
    }
}
