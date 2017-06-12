package com.interview.inherit;

/**
 * Created by ysx on 2017/6/12.
 */
public class FinallyReturnTest {

    public static void main(String[] args) {
        int result = func();
        System.out.println("result: " + result);

        System.out.println("************************************************");

        String resultStr = funcStr();
        System.out.println("resultStr: " + resultStr);

        System.out.println("************************************************");

        Person resultPerson = funcPerson();
        System.out.println("resultPerson.age: " + resultPerson.age);

    }

    public static int func() {
        int result = 0;
        try {
            result = 1;
            return result;
        } catch (Exception e) {
            result = 2;
            return result;
        } finally {
            result = 3;
        }
    }

    public static String funcStr() {
        String result = "hello";
        try {
            result = "1";
            return result;
        } catch (Exception e) {
            result = "2";
            return result;
        } finally {
            result = "3";
        }
    }

    public static Person funcPerson() {
        Person result = new Person(20);
        try {
            result.age = 30;
            return result;
        } catch (Exception e) {
            result.age = 40;
            return result;
        } finally {
            result.age = 50;
        }
    }


    static class Person {
        public int age;
        public Person(int age) {
            this.age = age;
        }
    }
}
