package com.example.effectivejava.chapter3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 84페이지, 126페이지 일반적으로 상속용 클래스에 Cloneable 인터페이스 사용을 권장하지 않는다.
 * 해당 클래스를 확장하려는 프로그래머에게 많은 부담을 주기 때문이다.
 */
public abstract class Shape implements Cloneable{
    private int area;
    public abstract int getArea();

    /**
     * 84페이지 부담을 덜기 위해서는 기본 clone() 구현체를 제공하여,
     * Cloneable 구현 여부를 서브 클래스가 선택할 수 있다.
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    /**
     * 85페이지 Cloneable 구현을 막을 수도 있다.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
