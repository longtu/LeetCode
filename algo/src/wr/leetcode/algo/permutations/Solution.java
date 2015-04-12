package wr.leetcode.algo.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,2,3};
        System.out.println(sol.permute(arr));
    }
}