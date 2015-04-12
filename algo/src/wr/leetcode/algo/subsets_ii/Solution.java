package wr.leetcode.algo.subsets_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,2,2 };
        System.out.println(sol.subsetsWithDup(arr));
    }
}