package com.interview.reflect;

/**
 * Created by ysx on 2017/6/12.
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("com.interview.reflect.Employee");
            Object person = c1.newInstance();
            if (person instanceof Employee) {
                System.out.println("age: " + ((Employee) person).getAge()
                        + "\nname: " + ((Employee) person).getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
