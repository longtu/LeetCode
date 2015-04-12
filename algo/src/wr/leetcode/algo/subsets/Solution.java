package wr.leetcode.algo.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

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
    }

    public static void main(String[] args) {
        Solution  sol = new Solution();
        int [] arr = {1,2,3};
        System.out.println(sol.subsets(arr));
    }


}