package wr.leetcode.algo.count_and_say;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i < 5; ++i) {
            System.out.println(sol.countAndSay(i));
        }
    }
}
