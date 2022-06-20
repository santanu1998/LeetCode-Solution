package com.LeetCode;

import java.util.stream.Collectors;

public class NumberOfEqualCountSubstrings {
    public static void main(String[] args) {
        String s = "abcaabcdba";
        int count = 2;
        int answer = equalCountSubstrings(s, count);
        System.out.println(answer);
    }
    private static int equalCountSubstrings(String s, int count) {
        int maxUnique = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
        int answer = 0;
        for (int unique = 1; unique <= maxUnique; ++unique) {
            int windowSize = unique * count;
            int[] lettersCount = new int[26];
            int uniqueCount = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (++lettersCount[s.charAt(i) - 'a'] == count)
                    ++uniqueCount;
                if (i >= windowSize && --lettersCount[s.charAt(i - windowSize) - 'a'] == count - 1)
                    --uniqueCount;
                answer += uniqueCount == unique ? 1 : 0;
            }
        }
        return answer;
    }
}
