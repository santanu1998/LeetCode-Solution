package com.LeetCode;

import java.util.*;

public class PhoneNumber {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
        String s = "two one nine six eight one six four six zero";
        String result = getPhoneNumber(s);
        System.out.println(result);
    }

    private static String getPhoneNumber(String s) {
//        boolean isValidInput = true;
//        long result = 0;
//        long finalResult = 0;
        StringBuilder ans;
        String result = "";
        List<String> allowedStrings = Arrays.asList
                (
                        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "double zero", "double one", "double two", "double three", "double four",
                        "double five", "double six", "double seven", "double eight", "double nine",
                        "triple zero", "triple one", "triple two", "triple three", "triple four",
                        "triple five", "triple six", "triple seven", "triple eight", "triple nine"
                );
        String[] splittedParts = new String[]{s};

//        if (s != null && s.length() > 0) {
//            s = s.replaceAll("-", " ");
//            s = s.toLowerCase().replaceAll(" and", " ");

//            for (String str : splittedParts) {
//                if (!allowedStrings.contains(str)) {
////                    isValidInput = false;
//                    return "Invalid";
//                }
//            }
        ans = new StringBuilder(result);
        for (String splittedPart : splittedParts) {
//            ans = new StringBuilder(result);
            if (splittedPart.equals(allowedStrings.get(0))) {
                ans.append("0");
            }
            else if (splittedPart.equals(allowedStrings.get(1))) {
                ans.append("1");
            }
            else if (splittedPart.equals(allowedStrings.get(2))) {
                ans.append("2");
            }
            else if (splittedPart.equals(allowedStrings.get(3))) {
                ans.append("3");
            }
            else if (splittedPart.equals(allowedStrings.get(4))) {
                ans.append("4");
            }
            else if (splittedPart.equals(allowedStrings.get(5))) {
                ans.append("5");
            }
            else if (splittedPart.equals(allowedStrings.get(6))) {
                ans.append("6");
            }
            else if (splittedPart.equals(allowedStrings.get(7))) {
                ans.append("7");
            }
            else if (splittedPart.equals(allowedStrings.get(8))) {
                ans.append("8");
            }
            else if (splittedPart.equals(allowedStrings.get(9))) {
                ans.append("9");
            }
            else if (splittedPart.equals(allowedStrings.get(10))) {
                ans.append("00");
            }
            else if (splittedPart.equals(allowedStrings.get(11))) {
                ans.append("11");
            }
            else if (splittedPart.equals(allowedStrings.get(12))) {
                ans.append("22");
            }
            else if (splittedPart.equals(allowedStrings.get(13))) {
                ans.append("33");
            }
            else if (splittedPart.equals(allowedStrings.get(14))) {
                ans.append("44");
            }
            else if (splittedPart.equals(allowedStrings.get(15))) {
                ans.append("55");
            }
            else if (splittedPart.equals(allowedStrings.get(16))) {
                ans.append("66");
            }
            else if (splittedPart.equals(allowedStrings.get(17))) {
                ans.append("77");
            }
            else if (splittedPart.equals(allowedStrings.get(18))) {
                ans.append("88");
            }
            else if (splittedPart.equals(allowedStrings.get(19))) {
                ans.append("99");
            }
            else if (splittedPart.equals(allowedStrings.get(20))) {
                ans.append("000");
            }
            else if (splittedPart.equals(allowedStrings.get(21))) {
                ans.append("111");
            }
            else if (splittedPart.equals(allowedStrings.get(22))) {
                ans.append("222");
            }
            else if (splittedPart.equals(allowedStrings.get(23))) {
                ans.append("333");
            }
            else if (splittedPart.equals(allowedStrings.get(24))) {
                ans.append("444");
            }
            else if (splittedPart.equals(allowedStrings.get(25))) {
                ans.append("555");
            }
            else if (splittedPart.equals(allowedStrings.get(26))) {
                ans.append("666");
            }
            else if (splittedPart.equals(allowedStrings.get(27))) {
                ans.append("777");
            }
            else if (splittedPart.equals(allowedStrings.get(28))) {
                ans.append("888");
            }
            else if (splittedPart.equals(allowedStrings.get(29))) {
                ans.append("999");
            }
            result = ans.toString();
        }
        return result;
    }
}
