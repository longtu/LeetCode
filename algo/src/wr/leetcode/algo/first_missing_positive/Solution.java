package wr.leetcode.algo.first_missing_positive;

public class Solution {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int firstMissingPositive(int[] nums) {
        int ret = 1;
        //BUG: && instead of ||
        if(null != nums && 0 != nums.length){
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                int j = i;
                while( nums[j] != j+1) {
                    int val = nums[j];
                    if ( val-1 >=0 && val-1 < n && nums[val-1] != val ) {
                        swap(nums, val-1, j);
                    }
                    else {
                        break;
                    }
                }
            }
            int i = 0;
            for ( ; i < n; ++i) {
                if (nums[i] != i+1) {
                    break;
                }
            }
            ret = i+1;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int[] arr : new int[][] {
                {1,2,0},
                {3,4,-1,1},
                {},
                null
        }) {
            System.out.println(sol.firstMissingPositive(arr));
        }
    }
}
