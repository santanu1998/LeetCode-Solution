package com.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EncryptAndDecryptStrings {

    Map<Character, String> encryptedMap;
    Map<String, Integer> waysToDecrypt;

    public EncryptAndDecryptStrings(char[] keys, String[] values, String[] dictionary) {
        encryptedMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            encryptedMap.put(keys[i], values[i]);
        }
        waysToDecrypt = new HashMap<>();
        for (String word : dictionary) {
            String encryptedString = encrypt(word);
            waysToDecrypt.put(encryptedString, waysToDecrypt.getOrDefault(encryptedString, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder encryptedString = new StringBuilder();
        for (char ch : word1.toCharArray()) {
            encryptedString.append(encryptedMap.get(ch));
        }
        return encryptedString.toString();
    }

    public int decrypt(String word2) {
        return waysToDecrypt.getOrDefault(word2, 0);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n =
        char[] keys = {};
        String[] values = {};
        String[] dictionary = {};
    }
}

