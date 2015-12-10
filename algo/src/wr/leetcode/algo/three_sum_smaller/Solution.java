package wr.leetcode.algo.three_sum_smaller;

import java.util.Arrays;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ret = 0;
        if( null != nums && nums.length > 2) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i + 2 < n; ++i) {
                ret += countSmallerPair( nums, i+1, n-1, target - nums[i]);
            }
        }
        return ret;
    }


    public int countSmallerPair( int[] nums, int left, int right, int target) {
        int count = 0;
        int start = left;
        int end = right;
        while(start <= end) {
            if(start == end) {
                //BUG: not always add for start == end, E.G input:
                //[3,1,0,-2] 4
                //count += start - left;
                int n = start - left + 1;
                count += n*(n-1)/2;
                start ++;
            } else {
                int val = nums[start] + nums[end];
                if (val < target) {
                    start ++ ;
                } else {
                    count += start - left;
                    end --;
                }
            }
        }
        return count;
    }


    //BUG: not always add for start == end, E.G input:
    //[3,1,0,-2] 4
    /*
    public int countSmallerPair( int[] nums, int left, int right, int target) {
        int count = 0;
        int start = left;
        int end = right;
        while(start <= end) {
            if(start == end) {
                count += start - left;
                start ++;
            } else {
                int val = nums[start] + nums[end];
                if (val < target) {
                    start ++ ;
                } else {
                    count += start - left;
                    end --;
                }
            }
        }
        return count;
    }
    */


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.threeSumSmaller(
                new int[] {-2,0,1,3},
                2
        ));
        System.out.println(sol.threeSumSmaller(
                new int[] {3,1,0,-2},
                4
        ));
    }
}
