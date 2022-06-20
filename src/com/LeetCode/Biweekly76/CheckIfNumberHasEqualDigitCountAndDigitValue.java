package com.LeetCode.Biweekly76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static void main(String[] args) {
        String num = "1210";
    }
    private static boolean digitCount(String num) {
        char[] ch = num.toCharArray();
        Integer arr = Integer.valueOf(String.valueOf(num));
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            for (Map.Entry entry : map.entrySet()) {
                if ((Integer) entry.getValue() == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
