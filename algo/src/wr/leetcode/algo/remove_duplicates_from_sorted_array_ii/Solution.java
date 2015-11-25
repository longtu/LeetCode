package wr.leetcode.algo.remove_duplicates_from_sorted_array_ii;

public class Solution {


    public int removeDuplicates(int[] nums) {
        if(null == nums) {
            nums = new int[0];
        }
        int write = 0;
        int n = nums.length;
        Integer key = null;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int val = nums[i];
            if( null == key || key != val) {
                key = val;
                count = 1;
                nums[write++] = val;
            } else {
                if(++count < 3) {
                    nums[write++] = val;
                }
            }
        }
        return write;
    }



    /*
    public int removeDuplicates(int[] A) {
        int ret = 0;
        if( null != A ) {
            int start = -1;
            int end = 0;
            int count = 0;
            while(end < A.length) {
                if(-1 == start || A[end] != A[start]){
                    count = 1;
                    A[++start] = A[end];
                } else if (A[end] == A[start] && count < 2) {
                    count++;
                    A[++start] = A[end];
                } else {
                    count++;
                }
                end++;
            }
            ret = start + 1;
        }
        return ret;
    }*/
}