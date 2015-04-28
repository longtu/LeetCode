package wr.leetcode.algo.maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(null == nums ) {
            nums = new int[0];
        }
        return maxSubArray(nums, 0, nums.length);
    }


    public int maxSubArray(int[] nums, int startInclusive, int endExclusive) {
        int sum = 0;
        if(startInclusive < endExclusive) {

            int mid = (startInclusive + endExclusive-1)/2;
            int leftSub = maxSubArray(nums, startInclusive, mid);
            int rightSub = maxSubArray(nums, mid+1,endExclusive);

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

            sum = Math.max( Math.max(leftSub, rightSub),
                    nums[mid] + leftMax + rightMax);
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sol.maxSubArray(arr));
    }
}
