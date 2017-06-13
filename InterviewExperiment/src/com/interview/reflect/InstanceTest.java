package com.interview.reflect;

/**
 * Created by ysx on 2017/6/13.
 * 使用Class.newInstance()创建新对象
 */
public class InstanceTest {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        try {
            person = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person.setAge(20);
        person.setName("James");
        System.out.println(person);
    }
}
