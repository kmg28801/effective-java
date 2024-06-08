package com.example.effectivejava.chapter3.추이성;

// 단순한 불변 2차원 정수 점(Point) 클래스 (56페이지)
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Point)) {
//            return false;
//        }
//        Point p = (Point) obj;
//        return p.x == x && p.y == y;
//    }


    // 잘못된 코드 - 리스코프 치환 원칙 위배 (59페이지)
    // ColorPoint는 ColorPoint 끼리 같고, Point는 Point 끼리 같아야 하지 않을까?
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}
