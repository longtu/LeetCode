package wr.leetcode.algo.three_sum_closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int ret = 0;
        if (null == num) {
            ret = 0;
        } else if (num.length <= 3) {
            ret = Arrays.stream(num).reduce(Integer::sum).orElse(0);
        } else {
            Arrays.sort(num);
            int minDiff = Integer.MAX_VALUE;
            for( int i = 0; i + 2 < num.length; ++i) {
                int closest = twoSumClosest(Arrays.copyOfRange(num, i+1, num.length),target-num[i]);
                int absDiff = Math.abs(closest + num[i] - target);
                if ( absDiff < minDiff) {
                    minDiff = absDiff;
                    ret = closest +num[i];
                }
            }
        }
        return ret;
    }

    public int twoSumClosest(int [] num, int target) {
        int start = 0;
        int end = num.length - 1;
        int ret = 0;
        int minDiff = Integer.MAX_VALUE;
        while (start < end) {
            int sum = num[start] + num[end];
            if(sum == target) {
                ret = target;
                break;
            } else {
                int absDiff = Math.abs(sum-target);
                if(absDiff < minDiff) {
                    minDiff = absDiff;
                    ret = target;
                }
                if (sum < target) {
                    start++;
                }else {
                    end--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {-1, 2, 1, -4};
        System.out.println(sol.threeSumClosest(arr, 1));
    }
}