package com.interview.inherit.pratice20170614;

/**
 * Created by ysx on 2017/6/14.
 */
public class ClassB extends ClassA{

    public static final String TAG = ClassB.class.getSimpleName();

    //静态方法不能隐藏父类中的实例方法
//    public static void method1(int i) {
//
//    }

    public void method2(int i) {
        System.out.println(TAG + " method2");
    }

    //实例方法不能覆盖父类中的静态方法
//    public void method3(int i) {
//
//    }

    //子类静态方法可以隐藏父类的静态方法
    public static void method4(int i) {
        System.out.println(TAG + " method4");
    }
}
