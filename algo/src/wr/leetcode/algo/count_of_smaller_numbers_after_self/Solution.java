package wr.leetcode.algo.count_of_smaller_numbers_after_self;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new LinkedList<>();

        if( null != nums) {
            int n = nums.length;
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            for (int i = n-1; i >=0; --i) {
                ret.add(0, countSmaller(tree, nums[i]));
                add(tree, nums[i]);
            }
        }
        return ret;
    }

    public int countSmaller( TreeMap<Integer, Integer> tree, int key) {
        /*return tree.headMap(key).entrySet()
                .stream()
                .mapToInt((a)->(a.getValue()))
                .sum();*/
        return tree.headMap(key).entrySet().size();

    }

    public void add ( TreeMap<Integer, Integer> tree, int key) {
        Integer cnt = tree.getOrDefault(key, 0) + 1;
        tree.put(key, cnt);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5, 2, 6, 1};
        System.out.println(sol.countSmaller(arr));

    }
}
