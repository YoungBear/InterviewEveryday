package com.interview.inherit.pratice20170614;

/**
 * Created by ysx on 2017/6/14.
 */
public class ClassA {

    public static final String TAG = ClassA.class.getSimpleName();

    public void method1(int i) {
        System.out.println(TAG + " method1");

    }

    public void method2(int i) {
        System.out.println(TAG + " method2");
    }

    public static void method3(int i) {
        System.out.println(TAG + " method3");

    }

    public static void method4(int i) {
        System.out.println(TAG + " method4");
    }
}
