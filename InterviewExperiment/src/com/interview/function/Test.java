package com.interview.function;

/**
 * Created by bearyang on 2017/1/18.
 */
public class Test {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + " , " + b);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
    /**
     * Java 程序设计语言对对象采用的不是引用调用，实际上，对象引用进行的是值传递。
     * Java 程序设计语言中方法参数的使用情况：
     * 1. 一个方法不能修改一个基本数据类型的参数
     * 2. 一个方法可以改变一个对象参数的状态
     * 3. 一个方法不能让对象参数引用一个新的对象
     * 此题违反了第3条。
     * x,y 是a,b的对象拷贝，也就是说y和b指向同一个对象，
     * 但是在方法里把y对象引用改变了，违反第3条，所以b的对象引用不会改变。
     * */
}
