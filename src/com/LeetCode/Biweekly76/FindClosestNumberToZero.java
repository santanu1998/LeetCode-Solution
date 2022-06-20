package com.LeetCode.Biweekly76;

import java.util.Arrays;
import java.util.Scanner;

public class FindClosestNumberToZero {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }*/
//        int[] nums = {-4, -2, 1, 4, 8};
        int[] nums = {61488,18221,-1321,90249,-62158,55128,-93476,53905,57644,24630,89599,-95795,-14891,-60298,17690,99022,-24006,-89156,80135,-46303,18812,59924,32024,82924,-47519,-77086,1763,68618,53629,-56957,95485,99630,-7977,31164,94481,-80239,-57749,-3319,-58231,-94841,-19292,33200,-31446,-3528,2229,74241,-19992,-91852,-28073,31453,-74484,35491,38870,-9499,39838,87369,21123,-38616,-89277,-14541,-81586,-18569,-58242,-71216,10816,15086,-10519,51080,53257,-4912,-37142,-16723,-69795,54937,-24920,68970,-10010,-81717,36203,-67939,73877,-58258,-57183,36637,91518,-8492,-57476,50523,62462,73152,-9511,-66761,28333,-87163,5187};
        int result = findClosestNumber(nums);
        System.out.println(result);
    }
    /*private static int findClosestNumber(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
//            min = Math.min(Math.abs(0 - min), Math.abs(0 - nums[i]));
            min = min > Math.abs(0- nums[i]) ? Math.abs(0- nums[i]) : Math.abs(min);
        }
        return min;
    }*/

    private static int findClosestNumber(int[] nums) {
        /*int currentValueHere = 0;
        int closestValue = nums[0];
        Arrays.sort(nums);

        for (int num : nums) {
            currentValueHere = num * num;
            if (currentValueHere <= (closestValue * closestValue)) {
                closestValue = num;
            }
        }
        return closestValue;*/

        if(nums.length == 0){
            return 0;
        }

        int closest = 0;

        for (int i = 0; i < nums.length ; i++) {
            if (closest == 0) {
                closest = nums[i];
            }
            else if (nums[i] > 0 && nums[i] <= Math.abs(closest)) {
                closest = nums[i];
            }
            else if (nums[i] < 0 && - nums[i] < Math.abs(closest)) {
                closest = nums[i];
            }
            else if (nums[i] == 0) {
                closest = nums[i];
            }
        }

        return closest;
    }
}
