package com.interview.reflect;

/**
 * Created by ysx on 2017/6/13.
 */
public class InterfaceLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> []interfaces = demo.getInterfaces();
//        String simpleName = interfaces[0].getSimpleName();
//        System.out.println("simpleName: " + simpleName);
        System.out.println("interfaces.length: " + interfaces.length);
    }
}
