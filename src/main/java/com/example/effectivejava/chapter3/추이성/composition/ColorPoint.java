package com.example.effectivejava.chapter3.추이성.composition;

import com.example.effectivejava.chapter3.추이성.Color;
import com.example.effectivejava.chapter3.추이성.Point;

import java.util.Objects;

// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60페이지)
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    //이 ColorPoint의 Point 뷰를 반환한다.
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}
