package wr.leetcode.algo.range_sum_query_immutable;

public class NumArray {
    final int n;
    final int[] sum;

    public NumArray(int[] nums) {
        if(null == nums) {
            nums = new int[0];
        }
        n = nums.length;
        sum = new int[n+1];
        int s = 0;
        for (int i = 0; i <=n; ++i) {
            sum[i] = s;
            if(i < n) {
                s += nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];

    }


    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray sol = new NumArray(arr);
        System.out.println(sol.sumRange(0,2));
        System.out.println(sol.sumRange(2,5));
        System.out.println(sol.sumRange(0,5));
    }
}
