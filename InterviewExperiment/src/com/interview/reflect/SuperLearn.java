package com.interview.reflect;

/**
 * Created by ysx on 2017/6/13.
 */
public class SuperLearn {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> superClass = demo.getSuperclass();
        System.out.println("superClass.getSimpleName(): " + superClass.getSimpleName());
    }

}
