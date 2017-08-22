package com.interview.boxlearn;

public class Test3 {

    public static void main(String[] args) {

        Byte b = 127;
        test(b);
        System.out.println(b);//输出为127

    }

    public static void test(Byte b) {
        Byte c = 10;
        b = c;
    }
}
