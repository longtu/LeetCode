package wr.leetcode.algo.combination_sum_iii;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

            List<List<Integer>> ret = new LinkedList<>();
            if( k < 0 || k > 9 || n <= 0 ) {
                return ret;
            }

            return combinationSum3(k, n, 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n, int start) {

            List<List<Integer>> ret = new LinkedList<>();
            if( k < 0 || n < 0) {
                return ret;
            }
            if( k == 0 && n == 0) {
                ret.add(new LinkedList<Integer>());
                return ret;
            }
            for (int i = start; i <= 10 - k; ++i ) {
                List<List<Integer>> subSols = combinationSum3(k-1, n-i, i+1);
                for (List<Integer> subSol : subSols) {
                    List<Integer> subSolCopy = new LinkedList<Integer>(subSol);
                    subSolCopy.add(0, i);
                    ret.add(subSolCopy);
                }
            }
            return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combinationSum3(3,7));
        System.out.println(sol.combinationSum3(3,9));
    }

}