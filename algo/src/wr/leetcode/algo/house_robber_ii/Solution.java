package wr.leetcode.algo.house_robber_ii;

import java.util.Arrays;

public class Solution {

    /*
    public int rob(int[] nums) {
        int ret = 0;
        //Did not think through empty/null check!!!
        if(null != nums && nums.length != 0) {
           if(1 == nums.length ) { //edge case !!! should have tested!
               ret = nums[0];
           } else {
               int[] lhs = Arrays.copyOfRange(nums, 0, nums.length);
               lhs[0] = 0;
               int[] rhs = Arrays.copyOfRange(nums, 0, nums.length);
               rhs[nums.length - 1] = 0;

               ret = Math.max(robBase(lhs), robBase(rhs));
           }
        }
        return ret;
    }

        public int robBase(int[] nums) {

        int [] loc = new int[nums.length];
        int [] glb = new int[nums.length];
        for ( int i = 0; i < nums.length; ++i) {
            loc[i] = nums[i] + ((i > 1)?(glb[i-2]):(0));
            glb[i] = Math.max(loc[i], (i > 0)?(glb[i-1]):(0));
        }
        return glb[nums.length-1];
    }*/

    public int rob(int[] nums) {
        int ret;
        if(null == nums || 0 == nums.length ){
            ret = 0;
        } else if (1 == nums.length) {
            ret = nums[0];
        } else {
            int tmp = nums[0];
            nums[0] = 0;
            int first = robCircle(nums);

            nums[0] = tmp;
            nums[nums.length -1] = 0;
            int second = robCircle(nums);
            ret = Math.max(first, second);
        }
        return ret;
    }

    public int robCircle(int[] nums) {
        int n = nums.length;
        int[] glo = new int[4];
        int[] loc = new int[4];
        for (int i = 0; i < n; ++i) {
            loc[i%4] = nums[i] + ((i > 1)?(glo[(i-2)%4]):(0));
            glo[i%4] = Math.max(loc[i%4], (i>0)?(glo[(i-1)%4]):(0));
        }
        return glo[(n-1)%4];
    }





    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {3,2,1};
        int[] b = {1,2,3};
        int[] c = {3,5,1};

        System.out.println(sol.rob(a));
        System.out.println(sol.rob(b));
        System.out.println(sol.rob(c));

    }
}
