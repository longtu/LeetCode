package wr.leetcode.algo.maximum_subarray;

import java.util.Map;

public class Solution {
    public int maxSubArray0(int[] nums) {
        if(null == nums ) {
            nums = new int[0];
        }
        return maxSubArray(nums, 0, nums.length);
    }


    public int maxSubArray(int[] nums, int startInclusive, int endExclusive) {
        int sum = 0;
        if(startInclusive < endExclusive) {
            int mid = (startInclusive + endExclusive-1)/2;
            int left = 0;
            int leftMax = 0;
            for (int x = mid-1; x >= startInclusive; x--){
                left += nums[x];
                leftMax = Math.max(left, leftMax);
            }

            int right = 0;
            int rightMax = 0;
            for (int x = mid+1; x < endExclusive; ++x) {
                right += nums[x];
                rightMax = Math.max(right, rightMax);
            }
            sum = nums[mid] + leftMax + rightMax;

            if(startInclusive < mid) {
                sum = Math.max(sum, maxSubArray(nums, startInclusive, mid));
            }
            if(mid +1 < endExclusive) {
                sum = Math.max(sum, maxSubArray(nums, mid+1,endExclusive));
            }
        }
        return sum;
    }

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        if(null == nums || nums.length == 0) {
            return sum;
        }

        int startInclusive = 0;
        int endExclusive = -1;
        while(startInclusive < nums.length) {
            sum += nums[startInclusive];
            max = Math.max(sum, max);
            while(sum < 0 && endExclusive < startInclusive) {
                endExclusive++;
                sum -= nums[endExclusive];
            }
            startInclusive++;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] b = {-1};

        System.out.println(sol.maxSubArray(arr));
        System.out.println(sol.maxSubArray(b));
    }
}
