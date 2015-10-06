package wr.leetcode.algo.missing_number;

public class Solution {
    public int missingNumber(int[] nums) {
        if( null == nums || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int ret = 0;
        for (int i = 1; i <=n; ++i){
            ret = ret^i;
        }
        for (int i = 0; i < n; ++i){
            ret = ret ^ nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {0,1,3};
        System.out.println(sol.missingNumber(arr));
    }
}
