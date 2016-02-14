package wr.leetcode.algo.combination_sum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3,6,7,2};
        System.out.println(sol.combinationSum(arr, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ret = new LinkedList<>();
        if( null != candidates && candidates.length > 0 ) {
            candidates = Arrays.stream(candidates).sorted().toArray();
            Set<List<Integer>> combinations = combinationSum(candidates, 0, target);
            ret = new LinkedList<>(combinations);
        }
        return ret;
    }

    public Set<List<Integer>> combinationSum(int[] candidates, int start, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        if ( 0 == target ) {
            ret.add(new LinkedList<>());
        } else {
            for (int i = start; i < candidates.length; ++i) {
                int key = candidates[i];
                if( target - key < 0 ) {
                    break;
                }
                Set<List<Integer>> subCombinations = combinationSum(candidates, i, target - key);
                for (List<Integer> subCombination : subCombinations) {
                    subCombination.add(0, key);
                    ret.add(subCombination);
                }
            }
        }
        return ret;
    }

    /*

    public List<List<Integer>> combinationSumRec(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();

        if(null == candidates || 0 == candidates.length) {
            return ret;
        } else if( 0 == target ) {
            List<Integer> r = new LinkedList<>();
            ret.add(r);
        } else {
            int first = candidates[0];
            Set<List<Integer>> set = new HashSet<>();
            if( first <= target ) {
                List<List<Integer>> subs = combinationSumRec(candidates, target - first);
                for (List<Integer> sub : subs) {
                    List<Integer> r = new LinkedList(sub);
                    r.add(0, first);
                    set.add(r);
                }
                if(candidates.length > 1) {
                    int[] subCandidates = Arrays.copyOfRange(candidates, 1, candidates.length);
                    List<List<Integer>> subRecs = combinationSumRec(subCandidates, target);
                    for (List<Integer> sub : subRecs) {
                        List<Integer> r = new LinkedList(sub);
                        set.add(r);
                    }
                }
            }
            ret.addAll(set);
        }
        return ret;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        if( 0 <= target ) {
            Arrays.sort(candidates);
            ret = combinationSumRec(candidates, target);
        }
        return ret;
    }

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
    }*/
}