package wr.leetcode.algo.string_to_integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        if(null == str) {
            str = "";
        }
        long ret = atoi(str.trim());
        if(ret > Integer.MAX_VALUE) {
            ret = Integer.MAX_VALUE;
        } else if (ret < Integer.MIN_VALUE) {
            ret = Integer.MIN_VALUE;
        }
        return (int)ret;
    }

    public long atoi(String str) {
        long ret = 0;
        int sign = 1;
        boolean isDigit = false;

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                isDigit = true;
                ret = (ch-'0') + ret*10;
            } else if((ch == '-' || ch == '+') && !isDigit) {
                sign = (ch == '-')?(-1):(1);
                isDigit = true;
            } else {
                break;
            }
            if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
                break;
            }
        }
        return sign * ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("9223372036854775809"));
        System.out.println(Long.MAX_VALUE);

    }
}
