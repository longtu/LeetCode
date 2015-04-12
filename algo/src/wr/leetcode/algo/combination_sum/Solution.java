package wr.leetcode.algo.combination_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates ) {
            candidates = new int[0];
        }
        //should sort
        int [] distinct = Arrays.stream(candidates).distinct().sorted().toArray();
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
        for (int i = 0; i*candidates[candidates.length-1] <= target; ++i) {
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
        return sols;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3,6,7,2};
        System.out.println(sol.combinationSum(arr, 7));
    }

}