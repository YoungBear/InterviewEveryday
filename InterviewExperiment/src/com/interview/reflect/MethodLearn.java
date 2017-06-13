package com.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ysx on 2017/6/13.
 */
public class MethodLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person person = null;

        Constructor<?> constructor = null;
        try {
            constructor = demo.getConstructor(int.class, String.class);
            person = (Person) constructor.newInstance(20, "James");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("before: " + person);

        try {
            Method methodGetAge = demo.getMethod("getAge");
            int age = (int) methodGetAge.invoke(person);
            System.out.println("age: " + age);

            Method methodSetAge = demo.getMethod("setAge", int.class);
            methodSetAge.invoke(person, 30);
            int ageAfter = (int) methodGetAge.invoke(person);
            System.out.println("ageAfter: " + ageAfter);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
