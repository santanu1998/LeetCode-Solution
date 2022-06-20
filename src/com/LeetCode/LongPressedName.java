package com.LeetCode;

public class LongPressedName {
    public static void main(String[] args) {
        String name = "vtkgn";
        String typed = "vttkgnn";
        boolean answer = isLongPressedName(name, typed);
        System.out.println(answer);
    }
    private static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int nameStart = 0;
        int typedStart = 0;
        while (nameStart < name.length() && typedStart < typed.length()) {
            if (name.charAt(nameStart) == typed.charAt(typedStart)) {
                nameStart++;
                typedStart++;
            }
            else if (nameStart > 0 && name.charAt(nameStart - 1) == typed.charAt(typedStart)) {
                typedStart++;
            }
            else {
                return false;
            }
        }
        while (typedStart < typed.length()) {
            if (name.charAt(nameStart - 1) != typed.charAt(typedStart)) {
                return false;
            }
            typedStart++;
        }
        return nameStart >= name.length();
    }
}
