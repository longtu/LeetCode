package wr.leetcode.algo.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new LinkedList();

        if(null == num ) {
            return ret;
        }

        if(num.length == 0) {
            ret.add(new LinkedList());
            return ret;
        }

        List<List<Integer>> subs = permute(Arrays.copyOfRange(num, 0
                , num.length - 1));
        for(List<Integer> sub : subs) {
            for (int i = 0; i < num.length; ++i) {
                List<Integer> sol = new LinkedList(sub);
                sol.add(i, num[num.length -1]);
                ret.add(sol);
            }
        }
        return ret;
    }*/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if( null == nums || 0 == nums.length ) {
            return ret;
        } else if( 1 == nums.length) {
            List<Integer> sub = new LinkedList<>();
            sub.add(nums[0]);
            ret.add(sub);
        } else {
            List<List<Integer>> subs = permute(Arrays.copyOfRange(nums, 1, nums.length));
            for (List<Integer> sub : subs) {
                for ( int i = 0; i <= sub.size(); ++i) {
                    List<Integer> r = new LinkedList<>(sub);
                    r.add(i, nums[0]);
                    ret.add(r);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,2,3};
        System.out.println(sol.permute(arr));
    }
}