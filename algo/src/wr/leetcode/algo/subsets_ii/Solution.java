package wr.leetcode.algo.subsets_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if( null != nums && 0 < nums.length) {
            Arrays.sort(nums);
            ret = subsetsRec(nums);
        }
        return ret;
    }

    public List<List<Integer>> subsetsRec(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        if( 0 == nums.length ) {
            ret.add(new LinkedList<>());
        } else {
            int first = nums[0];
            int[] subArray = Arrays.copyOfRange(nums, 1, nums.length);
            //BUG: Recursive to recursive function
            for (List<Integer> l : subsetsRec(subArray)) {
                List<Integer> r = new LinkedList<>(l);
                r.add(0, first);
                ret.add(r);
                ret.add(l);
            }
        }
        return new LinkedList<>(ret);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,2,2 };
        System.out.println(sol.subsetsWithDup(arr));
    }

     /*
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new LinkedList<>();
        if(null == num || 0 == num.length) {
            return ret;
        }

        Arrays.sort(num);
        return subsetsWithDupRec(num);

    }

    public List<List<Integer>> subsetsWithDupRec(int [] num) {

        List<List<Integer>> ret = new LinkedList();
        if(0 == num.length) {
            ret.add(new LinkedList<>());// this is missing initially!!
            return ret;
        }

        List<List<Integer>> subs = subsetsWithDupRec(Arrays.copyOfRange(num, 0, num.length - 1));

        for (List<Integer> sub : subs) {
            List<Integer> sol = new LinkedList(sub);
            ret.add(sol);
            sol = new LinkedList(sub);
            sol.add(num[num.length - 1]);
            ret.add(sol);
        }
        return new LinkedList<>(ret.stream().collect(Collectors.toSet()));
    }*/
}