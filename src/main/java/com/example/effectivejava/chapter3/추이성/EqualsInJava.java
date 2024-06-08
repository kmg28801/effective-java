package com.example.effectivejava.chapter3.추이성;

import java.net.MalformedURLException;
import java.sql.Date;
import java.sql.Timestamp;

public class EqualsInJava extends Object{
    public static void main(String[] args) throws MalformedURLException {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(time);

        //대칭성 위배! (60페이지)
        System.out.println(date.equals(timestamp));
        System.out.println(timestamp.equals(date));
    }
}
