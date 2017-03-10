package com.interview.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2017/2/23.
 */
public class PatternTest {

    public static void main(String[] args) {
//        String patternString = "\\w*er";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher("hellonever");
//        System.out.println("never match: " + matcher.matches());
//
//        Matcher matcher1 = pattern.matcher("er");
//        System.out.println("verb match: " + matcher1.matches());

        String patternString = "Bo{2,}+";
        Pattern pattern = Pattern.compile(patternString);
        String inputString = "Booosafa";
        Matcher matcher = pattern.matcher(inputString);
        System.out.println("matcher.lookingAt(): " + matcher.lookingAt());
//        System.out.println("zoo match: " + matcher.matches());
//        if (matcher.find()) {
//            int start = matcher.start();
//            int end = matcher.end();
//            String matchString = inputString.substring(start, end);
//            System.out.println("matchString: " + matchString);
//        }


    }


}
