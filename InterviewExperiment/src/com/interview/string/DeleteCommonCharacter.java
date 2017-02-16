package com.interview.string;

import java.util.Scanner;

/**
 * Created by bearyang on 2017/2/15.
 */
public class DeleteCommonCharacter {

    public static String deleteCommonCharacter(String source, String chars) {

        char[] sourceChars = source.toCharArray();
        boolean[] flags = new boolean[sourceChars.length];
        for (int i = 0; i < sourceChars.length; i++) {
            if (chars.contains(String.valueOf(sourceChars[i]))) {
                flags[i] = true;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sourceChars.length; i++) {
            if (!flags[i]) {
                sb.append(sourceChars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String chars = scanner.nextLine();
        String result = deleteCommonCharacter(source, chars);
        System.out.println(result);
    }
}
