package wr.leetcode.algo.string_to_integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        if(null == str) {
            str = "";
        }
        str.trim();
        int sign = 1;
        if(str.startsWith("+")){
            str = str.substring(1,str.length());
        } else if(str.startsWith("-")) {
            sign = -1;
            str = str.substring(1,str.length());
        }
        return (int) (sign * atoi(str));
    }

    public long atoi(String str) {
        long ret = 0;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            ret = (ch-'0') + ret*10;
        }
        return ret;
    }
}
