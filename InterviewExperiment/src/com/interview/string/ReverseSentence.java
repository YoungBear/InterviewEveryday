package com.interview.string;

import java.util.Scanner;

/**
 * Created by bearyang on 2017/2/15.
 */
public class ReverseSentence {

    public static String reverseSentence(String source) {
        String[] words = source.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        String source = "I like beijing.";
        String source = scanner.nextLine();
        String result = reverseSentence(source);
        System.out.println("result: " + result);
    }
}
