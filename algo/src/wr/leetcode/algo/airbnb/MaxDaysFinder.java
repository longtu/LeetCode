package wr.leetcode.algo.airbnb;

import java.util.Arrays;

public class MaxDaysFinder {

    public static int getMaxRentalDays(int[] nums) {
        nums = (null == nums) ? (new int[0]) : (nums);
        int ret = 0;
        int n = nums.length;
        if (n > 0) {
            int[] loc = new int[n];
            int[] glo = new int[n];
            for (int i = 0; i < n; ++i) {
                loc[i] = nums[i] + ((i - 2 >= 0) ? (glo[i - 2]) : (0));
                glo[i] = Math.max(loc[i], (i - 1 >= 0) ? glo[i - 1] : 0);
            }
            ret = glo[n - 1];
        }
        return ret;
    }

    public static int getMaxRentalDays0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
            }
        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i - 1]);
            prev2 = prev1;
            prev1 = curr;
            }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,3,1,5};

        for (int i = 0; i <= nums.length; ++i) {
            int [] ns = Arrays.copyOfRange(nums, 0, i);
            System.out.println(getMaxRentalDays(ns));
            System.out.println(getMaxRentalDays0(ns));
        }

    }

}
