package wr.leetcode.algo.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if( null != nums && 0 < nums.length) {
            Arrays.sort(nums);
            ret = subsetsRec(nums);
        }
        return ret;
    }

    public List<List<Integer>> subsetsRec(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
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
        return ret;
    }


    public static void main(String[] args) {
        Solution  sol = new Solution();
        int [] arr = {1,2,3};
        System.out.println(sol.subsets(arr));
    }

    /*
    public List<List<Integer>> subsetsRec(int [] S) {
        List<List<Integer>> ret = new LinkedList();
        if(S.length == 0) {
            List<Integer> sol = new LinkedList();
            ret.add(sol);
            return ret;
        }

        List<List<Integer>> subs = subsetsRec(Arrays.copyOfRange(S, 0, S.length - 1));
        for (List<Integer> sub : subs) {
            List<Integer> sol = new LinkedList(sub);
            ret.add(sol);
            sol = new LinkedList(sub);
            sol.add(S[S.length-1]);
            ret.add(sol);
        }
        return ret;
    }

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new LinkedList();

        if(null == S || S.length == 0) {
            return ret;
        }
        Arrays.sort(S);//initially this is missing
        return subsetsRec(S);
    }*/

}