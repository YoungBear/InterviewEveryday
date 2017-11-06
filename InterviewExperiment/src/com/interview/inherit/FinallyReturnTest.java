package com.interview.inherit;

/**
 * Created by ysx on 2017/6/12.
 */
public class FinallyReturnTest {

    public static void main(String[] args) {
        int result = func();
        System.out.println("result: " + result);

        System.out.println("************************************************");

        int resultGetNum = getNumber();
        System.out.println("resultGetNum: " + resultGetNum);

        System.out.println("************************************************");

        try {
            int resultGetNum1 = getNumber(0);
            System.out.println("resultGetNum1: " + resultGetNum1);
            System.out.println("************************************************");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("resultGetNum1: " + e.getLocalizedMessage());
        }


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

    /**
     * finally中的return语句会覆盖try和catch中的return语句
     * @return
     */
    public static int getNumber() {
        int num = 0;
        try {
            int result = 2 / num;
            return result;
        } catch (Exception exception) {
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            } else if (num == 1) {
                return 1;
            }
        }
    }

    /**
     * finally中的return语句会覆盖try和catch中的return语句
     * @return
     */
    public static int getNumber(int num) {
        try {
            if (num == 0) {
                throw new ArithmeticException("ArithmeticException try");
            }
            int result = 2 / num;
            return result;
        } catch (Exception exception) {
            throw new ArithmeticException("ArithmeticException catch");
        } finally {
            if (num == 0) {
                throw new ArithmeticException("ArithmeticException finally 0");
            } else if (num == 1) {
                throw new ArithmeticException("ArithmeticException finally 1");
            }
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
