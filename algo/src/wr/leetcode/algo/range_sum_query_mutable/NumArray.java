package wr.leetcode.algo.range_sum_query_mutable;

public class NumArray {

    final int n;
    final int[] bit;
    final int[] nums;


    public NumArray(int[] nums) {
        if(null == nums) {
            nums = new int[0];
        }
        this.n = nums.length;
        this.nums = nums;

        //initial set up as 0 and shift right by 1
        this.bit = new int[n+1];

        //initialize by add all values
        for (int i = 0; i < n; ++i) {
            //BUG: bitIndex is 1 more
            updateDiff(i+1, nums[i]);
        }
    }

    public void update(int i, int val) {
        //BUG: bitIndex is 1 more
        updateDiff(i+1, val - nums[i]);
        //BUG: remember to reflect the change
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }

    //update tree on the path to idx, with increase by diff
    private void updateDiff (int idx, int diff) {
        //pay attention to the loop here: need to go up to all root nodes
        while(idx <= n) {
            bit[idx] += diff;
            //Remember this important property: get right most 1
            idx += (idx & -idx);
        }
    }

    //cumulative sum ending at idx, inclusive
    private int sum(int idx) {
        int sum = 0;
        while(idx > 0) {
            sum += bit[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5};

        NumArray sol = new NumArray( nums );
        System.out.println(sol.sumRange(0,2));
        sol.update(1,2);
        System.out.println(sol.sumRange(0,2));
        System.out.println(sol.sumRange(0,1));
        System.out.println(sol.sumRange(0,0));
    }

}
