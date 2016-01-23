package wr.leetcode.algo.house_robber;

public class Solution {

    /*
    public int rob(int[] nums) {
        int sum = 0;
        if (null != nums && nums.length > 0) {
            int n = nums.length;
            int[] g = new int [4];
            int[] l = new int [4];
            for (int i = 0; i < n; ++i) {
                l[i%4] =  ((i>=2)?(g[(i-2)%4]):(0)) + nums[i];
                g[i%4] = Math.max( ((i>=1)?(g[(i-1)%4]):(0)), l[i%4]);
            }
            sum = g[(n-1)%4];
        }
        return sum;
    }


    public int rob(int[] nums) {
        int ret = 0;
        if(null != nums && 0 != nums.length) {
            int n = nums.length;
            int[] loc = new int[4];
            int[] glo = new int[4];

            for (int i = 0; i < n; ++i) {
                loc[i%4] = nums[i%4] +  ((i > 1)? (glo[(i-2)%4]) : (0));
                glo[i%4] = Math.max( loc[i%4], (i>0)?(glo[(i-1)%4]):(0));
            }
            ret = glo[(n-1)%4];
        }
        return ret;
    }*/

        public int rob(int[] nums) {
            //assert that nums is not null

            int n = nums.length;
            int[] glo = new int[n];
            int[] loc = new int[n];

            for (int i = 0; i < n; ++i) {
                loc[i] = ((i > 1)?(glo[i-2]):(0)) + nums[i];
                glo[i] = Math.max(loc[i], (i>0)?(glo[i-1]):(Integer.MIN_VALUE));
            }
            return (0==n)? (0) : glo[n-1];
        }

}
