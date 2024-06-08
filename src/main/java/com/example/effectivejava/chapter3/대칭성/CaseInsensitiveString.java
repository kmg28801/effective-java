package com.example.effectivejava.chapter3.대칭성;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 대칭성 위배 54-55 페이지
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

//    //대칭성 위배
//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        }
//        if (obj instanceof String) {
//            return s.equalsIgnoreCase((String) obj);
//        }
//        return false;
//    }

    //수정된 equals 메서드(56페이지)
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof CaseInsensitiveString) &&
                (((CaseInsensitiveString) obj).s.equalsIgnoreCase(s));
    }


    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String polish = "polish";
        System.out.println(cis.equals(polish));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(polish));
    }


}
