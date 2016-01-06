package wr.leetcode.algo.wiggle_sort_ii;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = (n+1)/2;
        int r = n;

        int[] sorted = new int[n];
        int i = 0;
        while( i < n ) {
            //BUG: i++ inline is bad here
            sorted[i] = (0 == (i%2))?(nums[--l]):(nums[--r]);
            i++;
        }
        for (i = 0; i < n; ++i)
            nums[i] = sorted[i];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int[] arr : new int[][] {
                {},
                {0},
                {1, 0},
                {1, 5, 1, 1, 6, 4},
                {1, 3, 2, 2, 3, 1},
                {4,5,5,6}
        }) {
            sol.wiggleSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
