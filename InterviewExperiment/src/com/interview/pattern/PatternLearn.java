package com.interview.pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternLearn {

    public static boolean isIpAddress(String ipAddress) {
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(rexp);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        boolean isIp = PatternLearn.isIpAddress(ipAddress);
        System.out.println("isIp: " + isIp);
    }
}
