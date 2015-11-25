package wr.leetcode.algo.next_permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if( null != nums && nums.length > 0 ) {
            int n = nums.length;
            boolean found = false;
            for (int i = n-1; i >=0 && !found; i--) {
                Integer val = nums[i];
                Integer bigger = null;
                for (int j = n-1; j > i; --j) {
                    if( (nums[j] > val) && (null == bigger || nums[j] < nums[bigger])) {
                        bigger = j;
                    }
                }
                if( null != bigger ) {
                    int tmp = nums[i];
                    nums[i] = nums[bigger];
                    nums[bigger] = tmp;
                    Arrays.sort(nums, i+1, n);
                    found = true;
                }
            }
            if(!found) {
                Arrays.sort(nums);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int[] arr : new int[][] {
                {1,2,3},
                {1,3,2},
                {2,1,3},
                {2,3,1},
                {3,1,2},
                {3,2,1},
                {1,1,5},
        }) {
            sol.nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
