package wr.leetcode.algo.string_to_integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        if(null == str) {
            str = "";
        }
        return (int) (atoi(str));
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
            } else if(isDigit) {
                break;
            } else if(ch == '-') {
                sign *= -1;
            }
        }
        return sign * ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("+-2"));
    }
}
