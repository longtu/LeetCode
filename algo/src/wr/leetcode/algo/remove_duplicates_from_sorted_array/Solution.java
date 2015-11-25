package wr.leetcode.algo.remove_duplicates_from_sorted_array;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if( null == nums ) {
            nums = new int[0];
        }
        int write = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if( i == 0 || nums[i] != nums[i-1]) {
                nums[write++] = nums[i];
            }
        }
        return write;
    }

    /*
    public int removeDuplicates(int[] A) {
        int ret = 0;
        if(null != A) {
            int start = -1;
            int end = 0;
            while(end < A.length) {
                if (start == -1 || A[end] != A[start]) {
                    A[++start] = A[end];
                }
                end++;
            }
            ret = start +1;
        }
        return ret;
    }*/
}
