package com.example.effectivejava.chapter3.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber number2 = new PhoneNumber(123, 456, 7890);

        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());

        map.put(number1, "kim");
        map.put(number2, "seo");

        String s1 = map.get(number2);
        System.out.println(s1);
        String s2 = map.get(new PhoneNumber(123, 456, 7890));
        System.out.println(s2);
    }
}
