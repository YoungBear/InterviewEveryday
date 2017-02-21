package com.interview.string;

import java.util.Scanner;

/**
 * Created by bearyang on 2017/2/16.
 */
public class LastWordLength {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        System.out.println(getLastWordLength(source));

    }

    public static int getLastWordLength(String source) {
        String[] words = source.split(" ");
        return words[words.length - 1].length();
    }
}
