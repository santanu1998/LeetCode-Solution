package com.LeetCode;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String variable = "hello";
        String answer = reverseVowels(variable);
        System.out.println(answer);
    }
    private static String reverseVowels(String variable) {
        char[] charArray = variable.toCharArray();
        int leftPointer = 0;
        int rightPointer = charArray.length - 1;
        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !isVowel(charArray, leftPointer)) {
                leftPointer++;
            }
            while (leftPointer < rightPointer && !isVowel(charArray, rightPointer)) {
                rightPointer--;
            }
            swapCharArray(charArray, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        }
        String charString = "";
        for (char chArray : charArray) {
            charString += chArray;
        }
        return charString;
    }

    private static boolean isVowel(char[] charArray, int leftPointer) {
        char ch = charArray[leftPointer];
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private static void swapCharArray(char[] charArray, int leftPointer, int rightPointer) {
        char tempChar = charArray[leftPointer];
        charArray[leftPointer] = charArray[rightPointer];
        charArray[rightPointer] = tempChar;
    }
}
