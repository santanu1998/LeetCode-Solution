package com.LeetCode;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> answerList = partitionLabels(s);
        System.out.println(answerList);
    }

    // 1. First Approach Using HashMap
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    /*private static List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashMap.put(ch, i);
        }
        List<Integer> answerList = new ArrayList<>();
        int previous = -1;
        int maximum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            maximum = Math.max(maximum, hashMap.get(ch));
            if (maximum == i) {
                answerList.add(maximum - previous);
                previous = maximum;
            }
        }
        return answerList;
    }*/

    // 1. First Approach Using PriorityQueue
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    private static List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) {
            return List.of(0);
        }
        List<Integer> result = new LinkedList<>();
        //use Integer instead of int, in case char with default start and end pos = 0
        Integer[][] member = new Integer[26][2];
        //find the start and end position for each char
        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if(member[ch][0] == null) {
                member[ch][0] = i;
            }
            member[ch][1] = i;
        }
        // Min Heat to keep the earliest start on top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> member[a][0]));
        for(int i = 0; i < member.length; i++) {
            if(member[i][0] != null) {
                pq.offer(i);
            }
            // Important: char may not exist! cause accessing null error for comparator
        }
        // Merge all overlapping chars
        while(!pq.isEmpty()){
            Integer ch = pq.poll();
            int start = member[ch][0];
            int end = member[ch][1];
            while(!pq.isEmpty() && end > member[pq.peek()][0]){
                // Compare with the start to find overlapping
                end = Math.max(end, member[pq.poll()][1]);
                // Update end by max with the end not start
            }
            result.add(end - start+1);
        }
        return result;
    }

}
