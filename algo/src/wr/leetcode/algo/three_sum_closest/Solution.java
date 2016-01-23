package wr.leetcode.algo.three_sum_closest;

import java.util.*;

public class Solution {

    public int threeSumClosest(int[] nums, int target){
        if (null == nums) {
            nums = new int[0];
        }
        int ans = nums[0];
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for ( int i = 0; i + 2 < n; ++i) {
            int key = target - nums[i];
            int diff = twoSum(Arrays.copyOfRange(nums,i+1,n), key);
            if (Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
                ans =  target - diff;
            }

        }
        return ans;
    }


    public int twoSum(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length-1;
        while( l < r) {
            int sum = nums[l] + nums[r];
            if ( sum == target ) {
                minDiff = 0;
                break;
            } else {
                if ( Math.abs(target - sum) < Math.abs(minDiff)) {
                    minDiff = target - sum;
                }
                if (sum < target) {
                    l ++;
                } else {
                    r --;
                }
            }
        }
        return minDiff;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,-3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,-82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,-92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,-58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,-10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,-21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,-69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90};
        System.out.println(sol.threeSumClosest(arr, 284));
        int[] a1 = {-1, 2, 3};
        System.out.println(sol.threeSumClosest(a1, 1));

    }

        /*
            public int threeSumClosest(int[] nums, int target) {

        int ret = 0;
        if( null != nums && nums.length > 2) {
            int n = nums.length;
            int minDiff = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i + 2 < n; ++i ) {
                int val = nums[i];
                int t = target - val;
                int[] subNums = Arrays.copyOfRange(nums, i + 1, n);
                int diff = twoSum(subNums, t);
                if(Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                    ret = target - diff;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid Input!");
        }
        return ret;
    }

    public int twoSum(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n-1;
        int minDiff = Integer.MAX_VALUE;
        while( start < end ) {
            int l = nums[start];
            int r = nums[end];
            int sum = l + r;
            if( sum == target) {
                minDiff = 0;
                break;
            } else {
                int diff = target - sum;
                if(Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
                if (sum < target) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return minDiff;
    }






    public int threeSumClosest(int[] num, int target) {
        int ret = 0;
        if (null == num || num.length < 3) {
            throw new RuntimeException("Invalid Input");
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
                    ret = sum;
                }
                if (sum < target) {
                    start++;
                }else {
                    end--;
                }
            }
        }
        return ret;
    }*/
}