package com.interview.string;

import java.util.Scanner;

/**
 * Created by bearyang on 2017/2/16.
 */
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine().toLowerCase();
        char ch = scanner.nextLine().toString().charAt(0);
        System.out.println(getCharNumber(sentence, ch));
    }

    public static int getCharNumber(String sentence, char ch) {
        int result = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ch) {
                result++;
            }
        }
        return result;
    }
}
