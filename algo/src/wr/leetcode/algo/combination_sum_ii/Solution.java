package wr.leetcode.algo.combination_sum_ii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates ) {
            candidates = new int[0];
        }
        //should sort
        int [] distinct = Arrays.stream(candidates).filter(a->a<=target).sorted().toArray();
        return combinationSumRec(distinct, target);
    }

    public List<List<Integer>> combinationSumRec(int[] candidates, int target) {
        List<List<Integer>> sols = new LinkedList();

        if(0 == target) {
            sols.add(new LinkedList());
            return sols;
        }

        if(candidates.length == 0) {
            return sols;
        }
        //should start from 0 instead of 1
        for (int i = 0; i*candidates[candidates.length-1] <= target && i <=1 ; ++i) {
            List<List<Integer>> subs = combinationSumRec (
                    Arrays.copyOfRange(candidates, 0, candidates.length-1)
                    ,target - i*candidates[candidates.length-1]);
            for(List<Integer> sub : subs){
                List<Integer> sol = new LinkedList(sub);
                for(int j = 1; j <=i; ++j) {
                    sol.add(candidates[candidates.length-1]);
                }
                sols.add(sol);
            }
        }
        return new LinkedList<>(new HashSet(sols));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {13,23,25,11,7,26,14,11,27,27,26,12,8,20,22,34,27,17,5,26,31,11,16,27,13,20,29,18,7,14,13,15,25,25,21,27,16,22,33,8,15,25,16,18,10,25,9,24,7,32,15,26,30,19};
        System.out.println(sol.combinationSum(arr, 25));
    }
}