package wr.leetcode.algo.wiggle_sort;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int j;
            if (i%2 == 0) {
                j = findEdge(false, i, nums);
            } else {
                j = findEdge(true, i, nums);
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public int findEdge ( boolean isMax, int start, int [] nums ) {
        int n = nums.length;

        int ret = start;
        int mVal = nums[start];
        for (int i = start + 1 ; i < n; ++i ) {
            int val = nums[i];
            if(isMax) {
                if(val > mVal){
                    mVal = val;
                    ret = i;
                }
            } else {
                if( val < mVal) {
                    mVal = val;
                    ret = i;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = {3, 5, 2, 1, 6, 4};
        sol.wiggleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
