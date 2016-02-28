package wr.leetcode.algo.Linkedin;

public class BalancedPoint {


    public int findBalancedPoint(int[] nums) {
        int ret = -1;
        int n = nums.length;

        long totalSum = 0;
        for (int v : nums) {
            totalSum += v;
        }

        long leftSum = 0;
        for (int i = 0; i < n; ++i) {
            if (leftSum == totalSum - nums[i] - leftSum) {
                ret = i;
            }
            leftSum += nums[i];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] input = {
                {},
                {0},
                {2,5,3,6,10},
                {1,2,1,3,0},
                {3,4,5}
        };
        BalancedPoint solution = new BalancedPoint();

        for (int [] s : input) {
            System.out.println(solution.findBalancedPoint(s));
        }
    }
}
