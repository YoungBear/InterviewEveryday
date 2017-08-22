package com.interview.boxlearn;

public class IntegerTest {

    public static void main(String[] args) {

        Integer a = 1;
        test(a);
        System.out.println(a);//输出为1
        test1(a);
        System.out.println(a);//输出为1

        Integer b = 1000;
        test(b);
        System.out.println(b);//输出为1000
        test1(b);
        System.out.println(b);//输出为1000
    }

    public static void test(Integer s) {
        s = 123;
    }

    public static void test1(Integer s) {
        s = s + 1;
    }

}
