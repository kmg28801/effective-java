package com.example.effectivejava.chapter3.hashcode;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + " : " + val);
        }
        return (short) val;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (!(obj instanceof PhoneNumber)) {
//            return false;
//        }
//        PhoneNumber phoneNumber = (PhoneNumber) obj;
//        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix && phoneNumber.areaCode == areaCode;
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    //코드 13-1 가변 상태를 참조하지 않는 클래스용 Clone 메서드(79쪽)
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); //일어날 수 없는 일
        }
    }

    public static void main(String[] args) {
//        Map<PhoneNumber, String> map = new HashMap<>();
//        map.put(new PhoneNumber(707, 867, 5309),"A");
//        System.out.println(map.get(new PhoneNumber(707, 867, 5307)));

        PhoneNumber phoneNumber = new PhoneNumber(707, 867, 5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(phoneNumber, "제니");
        PhoneNumber clone = phoneNumber.clone();
        System.out.println(clone != phoneNumber); //반드시 true
        System.out.println(clone.getClass() == phoneNumber.getClass()); // 반드시 true
        System.out.println(clone.equals(phoneNumber)); //true가 아닐 수 있다.
    }
}
