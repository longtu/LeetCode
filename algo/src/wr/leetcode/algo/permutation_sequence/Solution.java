package wr.leetcode.algo.permutation_sequence;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {


    public String getPermutation(int n, int k) {
        int[] perms = perms(n);
        if( k <=0 || k > perms[n-1]) {
            throw new IllegalArgumentException("Invalid k");
        }

        ArrayList<Integer> digits = new ArrayList<>(IntStream.range(1,n+1)
                                    .boxed()
                                    .collect(Collectors.toList()));

        k -= 1;
        StringBuilder sb = new StringBuilder();
        while(!digits.isEmpty()) {
            int size = digits.size();
            if(1 == size) {
                sb.append(digits.remove(0));
            } else {
                int i = size - 1;
                int mod = perms[i-1];
                int p = k / mod;
                sb.append(digits.remove(p));
                k = k % mod;
            }
        }
        return sb.toString();
    }

    public int[] perms( int n ) {
        int[] ret = new int[n];
        int p = 1;
        for (int i = 1; i <= n; ++i) {
            p *= i;
            ret[i-1] = p;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        for ( int i = 1; i <= 6; ++i )
            System.out.println(sol.getPermutation(3, i));

    }






    /*
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
    }*/
}
