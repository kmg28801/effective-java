package com.example.effectivejava.chapter3.추이성;

//Point에 값 컴포넌트(Color)를 추가 (56페이지)
public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

//    //코드 10-2 잘못된 코드 - 대칭성 위배 (57페이지)
//    //Point는 부모 속성으로 비교하고 Color는 따로 속성 비교를 하면 되지 않을까?
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof ColorPoint)) {
//            return false;
//        }
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }


    // 코드 10-3 잘못된 코드 - 추이성 위배! (57페이지)
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }

        // obj가 일반 Point면 색상을 무시하고 비교한다.
        if (!(obj instanceof ColorPoint)) {
            return obj.equals(this);
        }

        // obj가 ColorPoint면 색상까지 비교한다.
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

    public static void main(String[] args) {
        // 첫 번째 equals 메서드(코드 10-2)는 대칭성을 위배한다. (57 페이지)
//        Point p = new Point(1, 2);
//        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
//        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // 두 번째 equals 메서드(코드 10-3)는 추이성을 위배한다.
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
