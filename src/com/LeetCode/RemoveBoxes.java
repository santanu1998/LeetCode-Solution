package com.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes {
    public static void main(String[] args) {
        int[] boxes = {1, 2, 1, 2, 1};
        int ans = removeBoxes(boxes);
        System.out.println(ans);
    }
    /*
    private static int removeBoxes(int[] boxes) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(boxes);
        int count = 0;
        for (int box : boxes) {
            if (map.containsKey(box)) {
                map.put(box, map.get(box) + 1);
            } else {
                map.put(box, 1);
            }
        }
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            count += ent.getValue() * ent.getValue();
        }
        return count;
    }
    */

    private static int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        int length = boxes.length;
        int[][][] dynamic = new int[length][length][length];
        return getValue(dynamic, boxes, 0, length - 1, 0);
    }

    private static int getValue(int[][][] dynamic, int[] boxes, int low, int high, int middle) {
        if (low > high) {
            return 0;
        }
        else if (low == high) {
            return (middle + 1) * (middle + 1);
        }
        else if (dynamic[low][high][middle] != 0) {
            return dynamic[low][high][middle];
        }
        else {
            int maximum = getValue(dynamic, boxes, low + 1, high, 0) + (middle + 1) * (middle + 1);
            for (int i = low + 1; i <= high; i++) {
                if (boxes[low] == boxes[i]) {
                    maximum = Math.max(maximum, getValue(dynamic, boxes, low + 1, i - 1, 0) +
                            getValue(dynamic, boxes, i, high, middle + 1));
                }
            }
            dynamic[low][high][middle] = maximum;
            return maximum;
        }
    }
}
