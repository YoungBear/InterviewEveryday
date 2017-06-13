package com.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ysx on 2017/6/13.
 */
public class FieldLearn {

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

        //获取所有属性，这里只显示用
        Field[] fields = demo.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(i + " : " + fields[i].getName());
        }

        try {
            //可以通过这种方式修改private属性的的值
            Field fieldAge = demo.getDeclaredField("age");
            fieldAge.setAccessible(true);
            fieldAge.set(person, 33);
            System.out.println(fieldAge.get(person));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("after: " + person);
    }
}
