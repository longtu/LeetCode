package wr.leetcode.algo.product_of_array_except_self;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return nums;
        }

        int n = nums.length;
        int [] ret = new int [n];

        int val = 1;
        for (int i = 0; i < n; ++i) {
            ret[i] = val;
            val *= nums[i];
        }
        val = 1;
        for (int i = n-1; i >=0; --i) {
            ret[i] *= val;
            val *= nums[i];
        }
        return ret;
    }


    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
    }



        /*
    public int[] productExceptSelf(int[] nums) {
        int[] ret = null;
        if( null != nums) {
            ret = new int [nums.length];
            int left = 1;
            for (int i = 0; i < nums.length; ++i) {
                ret[i] = left;
                left = nums[i]*left;
            }
            int right = 1;
            //boundary of nums.length !!!
            for (int i = nums.length-1; i >=0; --i) {
                ret[i] = right * ret[i];
                right = nums[i]*right;
            }
        }
        return ret;
    }
    */
}
