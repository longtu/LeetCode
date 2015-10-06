package wr.leetcode.algo.happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Long> history = new HashSet<>();
        long val = n;

        while( val != 1l) {
            if(history.contains(val)) {
                break;
            }
            history.add(val);
            val = iterate(val);
        }
        return (1l == val);
    }

    private long iterate(long key) {
        String val = Long.toString(key);
        long ret = 0;
        for ( char ch : val.toCharArray()) {
            long n = (ch - '0');
            ret += n * n;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
        System.out.println(sol.isHappy(0));
        System.out.println(sol.isHappy(1));
        System.out.println(sol.isHappy(2));
        System.out.println(sol.isHappy(3));

    }
}
