package wr.leetcode.algo.permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new LinkedList();
        if(null == num) {
            return ret;
        }
        if(0 == num.length) {
            ret. add(new LinkedList());
            return ret;
        }

        List<List<Integer>> subs = permuteUnique(Arrays.copyOfRange(num, 0, num.length - 1));
        for (List<Integer> sub : subs) {
            for(int i = 0; i < num.length; ++i) {
                List<Integer> sol = new LinkedList(sub);
                sol.add(i, num[num.length-1]);
                ret.add(sol);
            }
        }
        return ret.parallelStream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {3,3,0,0,2,3,2};
        System.out.println(sol.permuteUnique(arr));
    }
}
