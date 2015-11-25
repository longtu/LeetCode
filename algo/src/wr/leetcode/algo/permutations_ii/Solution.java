package wr.leetcode.algo.permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if( null == nums || 0 == nums.length ) {
            return ret;
        } else if (1 == nums.length) {
            List<Integer> l = new LinkedList<>();
            l.add(nums[0]);
            ret.add(l);
        } else {
            Set<List<Integer>> next = new HashSet<>();
            List<List<Integer>> subs = permuteUnique(Arrays.copyOfRange(nums, 1, nums.length));
            for (List<Integer> sub : subs) {
                for (int i = 0; i <= sub.size(); ++i) {
                    List<Integer> n = new LinkedList<>(sub);
                    n.add(i, nums[0]);
                    next.add(n);
                }
            }
            ret = new LinkedList<>(next);
        }
        return ret;
    }

    /*
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new LinkedList();
        if(null == num) {
            return ret;
        }
        if(0 == num.length) {
            ret. add(new LinkedList());
            return ret;
        }

        List<List<Integer>> subs = permuteUnique(Arrays.copyOfRange(num, 0, num.length - 1));
        for (List<Integer> sub : subs) {
            for(int i = 0; i < num.length; ++i) {
                List<Integer> sol = new LinkedList(sub);
                sol.add(i, num[num.length-1]);
                ret.add(sol);
            }
        }
        return ret.parallelStream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] arr = { {1,1,2}, {1,1,1} };
        for (int [] ar : arr) {
            System.out.println(sol.permuteUnique(ar));
        }
    }
}
