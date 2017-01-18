package com.interview.function;

/**
 * Created by bearyang on 2017/1/18.
 */
public class Example {

    private String str = "good";
    private char[] ch = {'a', 'b', 'c'};
    private B b;

    public Example(B b) {
        this.b = b;
    }

    public static void main(String[] args) {
        Example ex = new Example(new B(10));
        ex.change(ex.str, ex.ch);
        ex.change(ex.b);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
        System.out.println("ex.b.getValue(): " + ex.b.getValue());
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

    public void change(B b) {
        b.setValue(123);
    }

    private static class B {

        int value;
        public B(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
