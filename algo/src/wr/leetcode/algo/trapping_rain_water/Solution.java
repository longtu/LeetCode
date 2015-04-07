package wr.leetcode.algo.trapping_rain_water;

public class Solution {
    public int trap(int[] A) {
    	int sum = 0;
    	if (null == A) {
    		return sum;
    	}
    	int len = A.length;
    	int[] leftMax = new int[len];
    	int[] rightMax = new int[len];

    	int maxLeft = 0;
    	int maxRight = 0;

    	for (int i = 0; i < len; ++i) {
    		leftMax[i] = maxLeft;
    		maxLeft = Math.max(A[i], maxLeft);
    	}
    	for (int i = len-1; i >= 0; --i) {
    		rightMax[i] = maxRight;
    		maxRight = Math.max(A[i], maxRight);
    	}

    	for (int i = 0; i < len; ++i) {
    		int level = Math.min(rightMax[i], leftMax[i]);
    		sum += (level > A[i])?(level-A[i]):(0);
    	}
    	return sum;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(arr));
    }
}