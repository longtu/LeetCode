package wr.leetcode.algo.longest_increasing_subsequence;


public class Solution {


    public int bstFirstRight (int[] nums, int len, int target) {
        int ret = len+1;
        int start = 0;
        int end = len;

        while (start <= end) {
            int mid = start + ((end-start) >> 1);
            int mv = nums[mid];
            if(mv > target) {
                ret = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }

    public int lengthOfLIS(int[] nums) {
        int ret = 0;
        if ( null != nums && nums.length > 0 ) {
            int n = nums.length;
            int[] end = new int[n];
            end[0] = nums[0];
            int len = 0;
            for (int i = 1; i < n; ++i) {
                int l = bstFirstRight(end, len, nums[i]);
                end[l] = nums[i];
                len = Math.max(l, len);
            }
            ret = len + 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr = {
                {1,2,3,8},
                {10, 9, 2, 5, 3, 7, 101, 18},
                {1,3,6,7,9,4,10,5,6}
        };

        for (int[] a : arr) {
            System.out.println("----");
            System.out.println(sol.lengthOfLIS(a));
        }
    }
}
