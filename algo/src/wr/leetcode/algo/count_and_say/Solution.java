package wr.leetcode.algo.count_and_say;

public class Solution {
    /*
    public String countAndSay(int n) {

        String str = "";
        for (int i = 1; i <= n; ++i) {
            if( 1 == i ) {
                str = "1";
            } else {
                str = countAndSay(str);
            }
        }
        return str;
    }

    public String countAndSay( String str ) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int count = 0;
        int key = 0;
        for (int i = 0; i <= n; ++i) {
            if(i == n) {
                sb.append(count);
                sb.append(key);
            } else {
                int val = str.charAt(i) - '0';
                if( 0 == i ) {
                    count = 1;
                    key = val;
                } else if (key == val) {
                    count += 1;
                } else {
                    sb.append(count);
                    sb.append(key);
                    count = 1;
                    key = val;
                }
            }
        }
        return sb.toString();
    }*/

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            str = countAndSay(str);
        }
        return (n > 0)?(str):("");
    }

    public String countAndSay(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        StringBuilder sb = new StringBuilder();

        Character ch = null;
        int count = 0;
        for (int i = 0; i<=n; ++i) {
            if ( n == i) {
                sb.append(count);
                sb.append(ch);
            } else {
                Character val = arr[i];
                if (null == ch || !ch.equals(val)) {
                    if ( count > 0) {
                        sb.append(count);
                        sb.append(ch);
                    }
                    count = 1;
                    ch = val;
                } else {
                    count++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i < 6; ++i) {
            System.out.println(sol.countAndSay(i));
        }
    }
}
