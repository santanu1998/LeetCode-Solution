package com.GeeksForGeeks.Array;

public class FindTheNumberOfJumpsToReachXInTheNumberLineFromZero {
    public static void main(String[] args) {
        int distance = 8;
//        int answer = countJumps(distance);
        int answer = minJumps(distance);
        System.out.println(answer);
    }

    // 1. First Approach

    /*private static int getsum(int distance) {
        return (distance * (distance + 1)) / 2;
    }
    // Function to find the number of jumps
    // to reach X in the number line from zero
    private static int countJumps(int distance) {
        // First make number positive
        // Answer will be same either it is
        // Positive or negative
        distance = Math.abs(distance);
        // To store required answer
        int ans = 0;
        // Continue till number is lesser
        // or not in same parity
        while (getsum(ans) < distance || ((getsum(ans) - distance) & 1) > 0) {
            ans++;
        }
        // Return the required answer
        return ans;
    }*/

    // 2. Second Approach

    private static int minJumps(int distance) {
        int jumpCount = 1;
        int totalSum = 0;
        while (totalSum < distance) {
            totalSum += jumpCount;
            jumpCount++;
        }
        if ((totalSum - distance) % 2 == 0) {
            return jumpCount - 1;
        }
        else if ((totalSum + jumpCount - distance) % 2 == 0) {
            return jumpCount;
        }
        else {
            return jumpCount + 1;
        }
    }
}
