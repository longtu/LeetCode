package wr.leetcode.algo.string_to_integer_atoi;

public class Solution {


    /*
    * 1) What if overflows?
    * 2) Dealing with Neg?
    * 3) prefix/post trailing spaces
    * 4) emptyString
    **/

    public int myAtoi(String str) {
        int ret = 0;

        if( null != str && str.length() > 0) {
            long val = 0;
            int sign = 1;
            int n = str.length();
            int i = 0;
            //skips possible prefix spaces
            while( i < n && ' ' == str.charAt(i) ){
                i++;
            }
            //check possible sign
            if(i < n) {
                char signCh = str.charAt(i);
                if(signCh == '+'){
                    sign = 1;
                    i++;
                } else if(signCh == '-'){
                    sign = -1;
                    i++;
                }
            }
            //all digits
            while(i < n) {
                char ch = str.charAt(i);
                //BUG: CHECK FOR Long overflow as input is unbounded string
                if(ch < '0' || ch > '9' || (val >= Integer.MAX_VALUE * 10l)) {
                    break;
                } else {
                    val *= 10;
                    val += (ch - '0');
                    i++;
                }
            }
            val *= sign;

            //dealing with overflows
            if(val < Integer.MIN_VALUE){
                ret = Integer.MIN_VALUE;
            } else if (val > Integer.MAX_VALUE) {
                ret = Integer.MAX_VALUE;
            } else {
                ret = (int)(val);
            }
        }
        return ret;
    }


    /*
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
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "9223372036854775809",
                Long.toString(Long.MAX_VALUE),
                Long.toString(Long.MIN_VALUE),
                "   -12345  ",
                "   +76545xx  ",
                " ",
        }) {
            System.out.println(sol.myAtoi(str));
        }

    }
}
