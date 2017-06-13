package com.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ysx on 2017/6/13.
 * 使用构造函数创建新对象
 */
public class InstanceTest2 {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> []constructors = demo.getConstructors();

        //注意，返回的数组顺序不确定，所以不要使用下标来访问
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(i + " : " + constructors[i].toGenericString());
        }
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;

        try {
            Constructor<?> constructor1 = demo.getConstructor();
            System.out.println("constructor1: " + constructor1);
            person1 = (Person) constructor1.newInstance();

            Constructor<?> constructor2 = demo.getConstructor(int.class);
            System.out.println("constructor2: " + constructor2);
            person2 = (Person) constructor2.newInstance(20);

            Constructor<?> constructor3 = demo.getConstructor(String.class);
            System.out.println("constructor3: " + constructor3);
            person3 = (Person) constructor3.newInstance("James");

            Constructor<?> constructor4 = demo.getConstructor(int.class, String.class);
            System.out.println("constructor4: " + constructor4);
            person4 = (Person) constructor4.newInstance(20, "James");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);

    }
}
