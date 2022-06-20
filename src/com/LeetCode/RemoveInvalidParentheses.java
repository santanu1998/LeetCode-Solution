package com.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
//        String s = "()())()";
        String s = "(a)())()";
        List<String> answer = removeInvalidParentheses(s);
        System.out.println(answer);
    }

    /*public static Set<String> hashSet = new HashSet<>();
    public static int minimum = Integer.MAX_VALUE;
    private static void recursiveMethod(String s, String correctedString, int index, int left, int right, int minimumRemoved) {

        if ( index >= s.length()) {
            if (left == right && minimumRemoved <= minimum){
                minimum = minimumRemoved;
                hashSet.add(correctedString);
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch != ')' && ch != '(') {
            recursiveMethod(s, correctedString + ch , index + 1, left, right, minimumRemoved);
            // there is only one option when c is not a parenthese.
        }
        else {
            // 2 options if c is a parenthese
            if (ch == '(') {
                recursiveMethod(s, correctedString + ch , index + 1, left + 1, right, minimumRemoved);
            }
            else if ( left > right ) {
                // Don't recreate an invalid string. Close the bracket if only there is a valid one.
                recursiveMethod(s,correctedString + ch , index + 1, left, right + 1, minimumRemoved);
            }
            recursiveMethod(s, correctedString, index + 1, left, right , minimumRemoved + 1);
            // remove c ;
        }
    }
    private static List<String> removeInvalidParentheses(String s) {
        recursiveMethod(s, "", 0, 0, 0,0);
        return new ArrayList<>(hashSet);
    }*/

    /*private static Set<String> valid = new HashSet<>();
    private static int min = Integer.MAX_VALUE;

    private static List<String> removeInvalidParentheses(String s) {
        recursiveMethod(s, 0, 0, 0, 0, new StringBuilder());
        return valid.stream().collect(Collectors.toList()); // convert out set to a list
    }

    private static void recursiveMethod(String s, int l, int r, int i, int removed, StringBuilder sb) {
        if (removed > min) // no point in exploring a sub-optimal solution
            return;

        if (i == s.length()) { // traversed the entire string
            if (l == r) { // is valid
                if (min > removed) // we found a smaller solution, so reset
                    valid.clear();
                min = removed;
                valid.add(sb.toString());
            }
            return;
        }

        int len = sb.length();
        char c = s.charAt(i);
        if (c != '(' && c != ')') { // always keep non-parens char
            sb.append(c);
            recursiveMethod(s, l, r, i+1, removed, sb);
        } else {
            recursiveMethod(s, l, r, i+1, removed+1, sb); // consider sequence without current char
            sb.append(c); // now consider WITH the current char
            if (c == '(') {
                recursiveMethod(s, l+1, r, i+1, removed, sb);
            } else if (r < l) { // ensures adding ")" to current SB remains valid
                recursiveMethod(s, l, r+1, i+1, removed, sb);
            }
        }
        sb.deleteCharAt(len); // backtrack
    }*/

    private static List<String> removeInvalidParentheses(String s) {

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {

            String curr = q.remove();
            if (valid(curr)) {
                ans.add(curr);
            }

            for (int i = 0; i < curr.length(); i++) {

                char ichar = curr.charAt(i);
                if (ichar != '(' && ichar != ')') {
                    continue;
                }
                String part1 = curr.substring(0, i);
                String part2 = curr.substring(i + 1);
                String next = part1 + part2;
                if (!visited.contains(next)) {
                    if (ans.isEmpty() || ans.get(ans.size() - 1).length() < next.length()) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }

        return ans;
    }

    private static boolean valid(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            char ichar = str.charAt(i);
            if (ichar == '(') {
                n++;
            }
            else if (ichar == ')') {
                if (n == 0) {
                    return false;
                }
                n--;
            }
        }

        return n == 0;
    }
}
