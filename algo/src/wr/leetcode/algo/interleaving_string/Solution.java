package wr.leetcode.algo.interleaving_string;

public class Solution {

    public String notNull(String str) {
        return (null == str)?(""):(str);
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        s1 = notNull(s1);
        s2 = notNull(s2);
        s3 = notNull(s3);

        boolean ret = false;
        if( s1.length() + s2.length() == s3.length() ){
            int m = s1.length();
            int n = s2.length();

            boolean [][] valid = new boolean[m+1][n+1];
            valid[0][0] = true;

            for (int i = 0; i <= m; ++i) { //BUG: =
                for (int j = 0; j <= n; ++j) { // BUG: =
                    boolean isValid;
                    if(i == 0 && j == 0) {
                        isValid = true;
                    } else {
                        isValid = false;
                        if(i > 0) {
                            isValid = isValid || (valid[i-1][j] && (
                                s1.charAt(i-1) == s3.charAt(i+j-1)));
                        }
                        if(j > 0) {
                            isValid = isValid || (valid[i][j-1] && (
                                s2.charAt(j-1) == s3.charAt(i+j-1)));
                        }
                    }
                    valid[i][j] = isValid;
                }
            }
            ret = valid[m][n];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isInterleave("aabcc","dbbca","aadbbcbcac" ));
        System.out.println(sol.isInterleave("aabcc","dbbca","aadbbbaccc" ));
    }
}
