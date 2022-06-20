package com.HackerRank;

import java.util.*;

public class Phone{
    Map<String,Integer> map = new HashMap<>();
    public Phone(){
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }
    public String getNumberFromString(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        boolean prevIsDouble = false;
        boolean prevIsTriple = false;;
        while (right < s.length()) {
            if (s.charAt(right) == ' ' || right == s.length() - 1) {
                if (right == s.length() - 1) {
                    right = s.length();
                }
                String currentString = s.substring(left, right);
                if (currentString.equals("double")) {
                    prevIsDouble = true;
                }
                else if (currentString.equals("triple")) {
                    prevIsTriple = true;
                }
                else {
                    sb.append(map.get(currentString));
                    if (prevIsDouble) {
                        sb.append(map.get(currentString));
                    }
                    else if (prevIsTriple) {
                        sb.append(map.get(currentString));
                        sb.append(map.get(currentString));
                    }
                    prevIsDouble = false;
                    prevIsTriple = false;
                }
                right++;
                left = right;
            }
            else {
                right++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String phoneNumber = "eight double zero double one double six three seven eight";
        String phoneNumber = "nine five four seven two double seven five double eight";
        Phone telephoneNumber = new Phone();
        String answer = telephoneNumber.getNumberFromString(phoneNumber);
        System.out.println(answer);
    }
}
