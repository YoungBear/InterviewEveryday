package com.interview.boxlearn;

public class FloatTest {

    public static void main(String[] args) {
        Float f = 1.2f;
        test(f);
        System.out.println(f);//输出为1.2

        float f1 = 2.4f;
        test1(f1);
        System.out.println(f1);//输出为2.4
    }

    public static void test(Float f) {
        f = f + 1;
    }

    public static void test1(float f) {
        f = f + 1;
    }
}
