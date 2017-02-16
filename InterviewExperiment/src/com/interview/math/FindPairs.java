package com.interview.math;

import java.util.Scanner;

/**
 * Created by bearyang on 2017/2/15.
 */
public class FindPairs {
    /*

    [编程题] 求和
    输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
    输入描述:
    每个测试输入包含2个整数,n和m


    输出描述:
    按每个组合的字典序排列输出,每行输出一种组合

    输入例子:
            5 5

    输出例子:
            1 4
            2 3
            5
            */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
    }


    public static void test(int n, int m) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {

            }
        }
    }
}
