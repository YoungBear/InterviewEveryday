package com.interview.boxlearn;

public class DoubleTest {
    public static void main(String[] args) {

        Double d = 12.34D;
        test(d);
        System.out.println(d);//输出为12.34

        double d1 = 34.12D;
        test(d1);
        System.out.println(d1);//输出为34.12
    }

    public static void test(Double d) {
        d = d + 1;
    }

    public static void test1(double d) {
        d = d + 1;
    }
}
