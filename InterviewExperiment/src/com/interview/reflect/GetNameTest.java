package com.interview.reflect;

/**
 * Created by ysx on 2017/6/12.
 */
public class GetNameTest {

    /**
     * 可以看出，对于大部分class而言，getCanonicalName和getName这两个方法没有什么不同的， 但是对于array等就显示出来了。
     getName()方法，以String的形式，返回Class对象的‘实体’名称；
     getSimpleName()方法，是获取源代码中给出的‘底层类’简称；

     参考：http://www.cnblogs.com/birkhoff/p/5274562.html
     * */

    public static void main(String[] args) {
        Class person = null;
        try {
            person = Class.forName("com.interview.reflect.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (person != null) {
            System.out.println("Class.getName(): " + person.getName()
                    + "\nClass.getSimpleName(): " + person.getSimpleName()
                    + "\nClass.getCanonicalName(): " + person.getCanonicalName());
        }

        Person[] persons = new Person[2];
        Class c2 = persons.getClass();

        if (c2 != null) {
            System.out.println("Class.getName(): " + c2.getName()
                    + "\nClass.getSimpleName(): " + c2.getSimpleName()
                    + "\nClass.getCanonicalName(): " + c2.getCanonicalName());
        }

    }
}
