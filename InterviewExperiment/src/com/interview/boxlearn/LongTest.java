package com.interview.boxlearn;


public class LongTest {

    public static void main(String[] args) {

        Long a = 12345L;
        test(a);
        System.out.println(a);//输出为12345

        long b = 54321L;
        test1(b);
        System.out.println(b);//输出为54321

    }

    public static void test(Long a) {
        a = a + 1;
    }

    public static void test1(long a) {
        a = a + 1;
    }
}
