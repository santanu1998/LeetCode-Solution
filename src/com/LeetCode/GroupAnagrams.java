package com.LeetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> answer = groupAnagrams(strs);
        System.out.println(answer);
    }
    /*private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
            if (!hashMap.containsKey(frequencyMap)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(frequencyMap, list);
            }
            else {
                ArrayList<String> list = hashMap.get(frequencyMap);
                list.add(str);
            }
        }
        return new ArrayList<>(hashMap.values());
    }*/

    /*private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String keyString = String.valueOf(charArray);
            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<>());
            }
            map.get(keyString).add(string);
        }
        return new ArrayList<>(map.values());
    }*/

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] charArray = new char[26];
            for (char ch : string.toCharArray()) {
                charArray[ch - 'a']++;
            }
            String keyString = String.valueOf(charArray);
            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<>());
            }
            map.get(keyString).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
