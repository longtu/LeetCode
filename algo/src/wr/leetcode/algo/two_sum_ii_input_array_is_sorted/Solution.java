package wr.leetcode.algo.two_sum_ii_input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] ret = new int[2];
        int n = numbers.length;

        int left = 1;
        int right = n;

        while(left <= right) {
            int sum = numbers[left-1] + numbers[right-1];
            if( target == sum ) {
                ret[0] = left;
                ret[1] = right;
                break;
            } else if (sum < target) {
                left ++ ;
            } else {
                right--;
            }
        }
        return ret;
    }
}
