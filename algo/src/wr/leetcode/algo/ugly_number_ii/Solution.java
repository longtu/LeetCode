package wr.leetcode.algo.ugly_number_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int nthUglyNumber(int n) {
        Map<Integer, Integer> res = new HashMap<>();
        res.put(0,1);
        int lastTwo = 0;
        int lastThree = 0;
        int lastFive = 0;

        for (int i = 1; i < n; ++i) {
            int min = min( res.get(lastTwo)*2, res.get(lastThree)*3, res.get(lastFive)*5);
            res.put(i, min);
            if( min == res.get(lastTwo)*2) {
                lastTwo += 1;
            }
            if( min == res.get(lastThree)*3) {
                lastThree += 1;
            }
            if( min == res.get(lastFive)*5) {
                res.remove(lastFive);
                lastFive += 1;
            }
        }
        return res.get(n-1);
    }


    public int min (int a, int b, int c) {
        return Math.min(Math.min(a,b), c);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i = 1; i < 11; ++i) {
            System.out.println(sol.nthUglyNumber(i));
        }
    }
}
