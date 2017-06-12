package com.interview.inherit;

/**
 * Created by bearyang on 2017/2/15.
 */
public class Base {

    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println("baseName: " + baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        @Override
        public void callName() {
            System.out.println("baseName: " + baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}
