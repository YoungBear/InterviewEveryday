package com.interview.reflect;

import javax.print.attribute.standard.Fidelity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ysx on 2017/6/12.
 */
public class ReflectLearn {

    public static void main(String[] args) {
        try {
            Class person = Class.forName("com.interview.reflect.Employee");

//            System.out.println("Class.getName(): " + person.getName()
//                    + "\nClass.getSimpleName(): " + person.getSimpleName()
//                    + "\nClass.getCanonicalName(): " + person.getCanonicalName());

            System.out.println("********************DeclaredFields*****************");
            Field[] declaredFields = person.getDeclaredFields();
            for (Field item : declaredFields) {
                System.out.println("item.getName(): " + item.getName());
            }

            System.out.println("********************Fields*****************");
            Field[] fields = person.getFields();
            for (Field item : fields) {
                System.out.println("item.getName(): " + item.getName());
            }

            System.out.println("********************getDeclaredMethods*****************");
            Method[] declaredMethods = person.getDeclaredMethods();
            for (Method item : declaredMethods) {
                System.out.println("item.getName(): " + item.getName());
            }

            System.out.println("********************getMethods*****************");
            Method[] methods = person.getMethods();
            for (Method item : methods) {
                System.out.println("item.getName(): " + item.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
