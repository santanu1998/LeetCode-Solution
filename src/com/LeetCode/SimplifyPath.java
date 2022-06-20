package com.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";
        String answer = simplifyPath(path);
        System.out.println(answer);
    }

/*    public String simplifyPath(String path) {
         String[] tokens = path.split("/+");
         Stack<String> stack = new Stack<>();
         for (String token : tokens) {
             if (stack.size() > 0 && "..".equals(token)) {
                 stack.pop();
             }
             else if (!Arrays.asList("", ".", "..").contains(token)) {
                 stack.push(token);
             }
         }
         // StringBuilder sb = new StringBuilder();
         // for (String s : stack) {
         //     sb.append("/").append(s);
         // }
         // return sb.length() == 0 ? "/" : sb.toString();

         return "/" + String.join("/", stack);
     }*/

//     // 1. Using Stack

     /*public String simplifyPath(String path) {
         Stack<String> stack = new Stack<>();
         StringBuilder result = new StringBuilder();
         String[] tokens = path.split("/");
         for (int i = 0; i < tokens.length; i++) {
             if (!stack.isEmpty() && tokens[i].equals("..")) {
                 stack.pop();
             }
             else if (!tokens[i].equals("") && !tokens[i].equals(".") && !tokens[i].equals("..")) {
                 stack.push(tokens[i]);
             }
         }
         if (stack.isEmpty()) {
             return "/";
         }
         while (!stack.isEmpty()) {
             result.insert(0, stack.pop()).insert(0, "/");
         }
         return result.toString();
     }*/

        // 1. Using ArrayDeque

        private static String simplifyPath(String path) {
            Deque<String> deque = new LinkedList<>();
            StringBuilder result = new StringBuilder();
            String[] tokens = path.split("/");
            for (String token : tokens) {
                if (!deque.isEmpty() && token.equals("..")) {
                    deque.poll();
                } else if (!token.equals("") && !token.equals(".") && !token.equals("..")) {
                    deque.push(token);
                }
            }
            if (deque.isEmpty()) {
                return "/";
            }
            while (!deque.isEmpty()) {
                result.append("/").append(deque.pollLast());
            }
            return result.toString();
        }
}
