package com.interview.reflect;

/**
 * Created by ysx on 2017/6/12.
 */
public class ReflectLearn2 {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取Class的三种方法
        //Class.forName()
        Class c1 = Class.forName("com.interview.reflect.Employee");
        //ClassName.class
        Class c2 = Employee.class;
        //getClass()
        Employee e = new Employee(30, "John", 10000f);
        Class c3 = e.getClass();
    }
}
