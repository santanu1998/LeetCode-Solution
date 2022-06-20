package com.LeetCode;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean answer = isValidSerialization(preorder);
        System.out.println(answer);
    }

    private static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int vacancy = 1;
        for (String node : nodes) {
            vacancy--;
            if (vacancy < 0) {
                return false;
            }
            if (!node.equals("#")) {
                vacancy += 2;
            }
        }
        return vacancy == 0;
    }
}
