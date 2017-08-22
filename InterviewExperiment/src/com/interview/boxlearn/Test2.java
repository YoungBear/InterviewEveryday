package com.interview.boxlearn;

/**
 * 原题链接：https://www.nowcoder.com/questionTerminal/1bab09264a1c4528aa60ee9bca5f0976
 */

public class Test2 {

    public static void main(String[] args) {
        test();

    }

    /**
     * add函数内实现++操作，会自动拆包成byte值传递类型，所以原Byte的值不会变
     * */
    public static void add(Byte b) {
        b = b++;
    }

    public static void test() {
        Byte a = 127;
        Byte b = 127;

        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}
