package com.interview.reflect;

import java.lang.reflect.Constructor;

/**
 * Created by ysx on 2017/6/13.
 */
public class ConstructorLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[]constructors = demo.getConstructors();
//        Constructor<?>[]constructors = demo.getDeclaredConstructors();

        //注意，返回的数组顺序不确定，所以不要使用下标来访问
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(i + " : " + constructors[i].toGenericString());
        }
    }
}
