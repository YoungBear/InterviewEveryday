package com.interview.boxlearn;

public class StringTest {
    public static void main(String[] args) {

        String str = "main";
        test(str);
        System.out.println(str);//输出为main
        test1(str);
        System.out.println(str);//输出为main
    }

    public static void test(String s) {
        s = "in the function";
    }

    public static void test1(String s) {
        s = s + "123";
    }
}
