package com.interview.inherit.pratice20170614;

/**
 * Created by ysx on 2017/6/14.
 */
public class ClassABLearn {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        classA.method1(0);
        classA.method2(0);
        classA.method3(0);
        classA.method4(0);

        System.out.println("********************");

        //发生隐藏的时候，声明类型是什么类，就调用对应类的属性或者方法
        ClassA classB = new ClassB();
        classB.method1(0);
        classB.method2(0);
        classB.method3(0);
        classB.method4(0);

        System.out.println("********************");

        ClassB classB1 = new ClassB();
        classB1.method1(0);
        classB1.method2(0);
        classB1.method3(0);
        classB1.method4(0);

    }
}
