package wr.leetcode.algo.threesum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        if (null == nums) {
            nums = new int[0];
        }
        Arrays.sort(nums);
        int n = nums.length;

        for ( int i = 0; i + 2 < n; ++i) {
            Set<List<Integer>> twoSums = twoSum(Arrays.copyOfRange(nums,i+1,n),
                    0 - nums[i]);
            for ( List<Integer> two : twoSums) {
                List<Integer> three = new LinkedList<>(two);
                three.add(0, nums[i]);
                ans.add(three);
            }
        }
        return new LinkedList<>(ans);
    }


    public Set<List<Integer>> twoSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        int l = 0;
        int r = nums.length-1;
        while( l < r) {
            int sum = nums[l] + nums[r];
            if ( sum == target ) {
                List<Integer> two = new LinkedList<>();
                two.add(nums[l]);
                two.add(nums[r]);
                ret.add(two);
                l++;
            } else if ( sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return ret;
    }

    /*
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> ret = new HashSet<>();
        if( null != nums && nums.length > 2) {
            int n = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i + 2 < n; ++i ) {
                int val = nums[i];
                int[] subNums = Arrays.copyOfRange(nums, i + 1, n);
                Set<List<Integer>> subs = twoSum(subNums, 0 - val);
                for (List<Integer> s : subs) {
                    s.add(0, val);
                    ret.add(s);
                }
            }
        }
        return new LinkedList<>(ret);
    }

    public Set<List<Integer>> twoSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet();
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while( start < end ) {
            int l = nums[start];
            int r = nums[end];
            int sum = l + r;
            if( sum == target) {
                List<Integer> list = new LinkedList<>();
                list.add(l);
                list.add(r);
                ret.add(list);
                start ++;
            } else if (sum < target) {
                start ++;
            } else {
                end --;
            }
        }
        return ret;
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.threeSum(new int[] {
                7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6
        }));
    }
}
