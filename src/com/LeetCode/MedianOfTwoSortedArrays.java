package com.LeetCode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        /*int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10, 11, 12};*/
        int[] nums1 = { -5, 3, 6, 12, 15 };
        int[] nums2 = { -12, -10, -6, -3, 4, 10 };
        double answer = findMedianSortedArrays(nums1, nums2);
        System.out.println(answer);
    }

    // 2. Second Approach using Binary Search
    // Here Time Complexity is : O(min(log m, log n))
    // Here Auxiliary Space Complexity is : O(1)


    /*private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;


            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];


            if (left1 <= right2 && left2 <= right1) {
                if( (n1 + n2) % 2 == 0 )
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else {
                    return Math.max(left1, left2);
                }
            }
            else if(left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }*/


    // 1. First Approach using Linear and Naive
    // Here Time Complexity is : O(m + n)
    // Here Auxiliary Space Complexity is : O(1)


    private static int findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;
        if ((m + n) % 2 == 1) {
            for(count = 0; count <= (n + m) / 2; count++) {
                if (i != n && j != m) {
                    m1 = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
                }
                else if (i < n) {
                    m1 = nums1[i++];
                }
                else {
                    m1 = nums2[j++];
                }
            }
            return m1;
        }
        else {
            for(count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (nums1[i] > nums2[j]) ?
                            nums2[j++] : nums1[i++];
                }
                else if (i < n) {
                    m1 = nums1[i++];
                }
                else
                {
                    m1 = nums2[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
