package com.dsa.practice.leetcode.twoPointer;

import java.util.*;

public class Merge2DArrays {
    public List<List<Integer>> mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];

            if (id1 == id2) {
                result.add(Arrays.asList(id1, val1 + val2));
                i++;
                j++;
            } else if (id1 < id2) {
                result.add(Arrays.asList(id1, val1));
                i++;
            } else {
                result.add(Arrays.asList(id2, val2));
                j++;
            }
        }

        // Append remaining elements from nums1
        while (i < nums1.length) {
            result.add(Arrays.asList(nums1[i][0], nums1[i][1]));
            i++;
        }

        // Append remaining elements from nums2
        while (j < nums2.length) {
            result.add(Arrays.asList(nums2[j][0], nums2[j][1]));
            j++;
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Merge2DArrays merger = new Merge2DArrays();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        List<List<Integer>> result = merger.mergeArrays(nums1, nums2);

        for (List<Integer> entry : result) {
            System.out.println(entry);
        }
    }
}

