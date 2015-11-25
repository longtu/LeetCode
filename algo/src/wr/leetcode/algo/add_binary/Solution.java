package wr.leetcode.algo.add_binary;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String notNull(String str) {
        return (null == str)?(""):(str);
    }

    public String addBinary(String a, String b) {
        List<Integer> ret = new LinkedList<>();
        a = notNull(a);
        b = notNull(b);

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while( i >= 0 || j >= 0 || carry > 0) {
            int val = carry;
            if(i >= 0) {
                val += (a.charAt(i--) - '0');
            }
            if(j >= 0) {
                val += (b.charAt(j--) - '0');
            }
            carry = val/2;
            val = val%2;
            ret.add(0, val);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer val : ret) {
            sb.append(val);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addBinary("11", "1"));
    }
}
