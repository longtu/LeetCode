package wr.leetcode.algo.permutation_sequence;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String getPermutation(int n, int k) {
        int [] pNumbers = buildPermNumber(n);
        List<Integer> numbers = new LinkedList<>();
        for(int i = 1; i <=n; ++i)
            numbers.add(i);
        if(k < 1 || k > pNumbers[n]) {
            return null;
        }
        return getPermutation("", numbers, k-1, pNumbers);
    }

    public String getPermutation(String prefix, List<Integer> nums, int k, int[] pNumbers ) {

        //two bugs here, should bheck nums.size() instead of K
        //should return prefix + current value
        if( nums.size() == 1) {
            return prefix + nums.get(0);
        }

        int num = nums.size()-1;
        int d = pNumbers[num];
        int bucket = k/d;
        int index = k%d;

        String nextPrefix = prefix + nums.get(bucket);
        nums.remove(bucket);
        return getPermutation(nextPrefix, nums, index, pNumbers);
    }

    //initially there is a bug here!!!
    public int[] buildPermNumber(int n) {
        int[] ret = new int[n+1];
        ret[0] = 1;
        for (int i = 1; i <= n; ++i) {
            ret[i] = ret[i-1] * i;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(sol.getPermutation(8,8590));
        System.out.println((System.currentTimeMillis() - start)/1000);

    }
}
