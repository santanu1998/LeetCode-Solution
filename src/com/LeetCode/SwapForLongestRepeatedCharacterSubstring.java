package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SwapForLongestRepeatedCharacterSubstring {
    public static void main(String[] args) {
        String text = "aaabaaa";
        int result = maxRepOpt1(text);
        System.out.println(result);
    }
    private static int maxRepOpt1(String text) {
        int result = 0;
        int[] counts = new int[26];
        List<int[]> group = new ArrayList<>();

        for (char c : text.toCharArray())
            ++counts[c - 'a'];

        group.add(new int[] {text.charAt(0), 1});

        for (int i = 1; i < text.length(); ++i)
            if (text.charAt(i) == text.charAt(i - 1))
                ++group.get(group.size() - 1)[1];
            else
                group.add(new int[] {text.charAt(i), 1});

        for (int[] grouping : group)
            result = Math.max(result, Math.min(grouping[1] + 1, counts[grouping[0] - 'a']));

        for (int i = 1; i + 1 < group.size(); ++i)
            if (group.get(i - 1)[0] == group.get(i + 1)[0] && group.get(i)[1] == 1)
                result = Math.max(result, Math.min(group.get(i - 1)[1] + group.get(i + 1)[1] + 1,counts[group.get(i - 1)[0] - 'a']));

        return result;
    }
}
