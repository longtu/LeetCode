package wr.leetcode.algo.regular_expression_matching;

public class Solution {

    /*
    public String notNull(String str) {
        return (null == str)? (""):(str);
    }

    public String replace(String str) {
        return str.replaceAll("\\*+", "*");
    }

    public boolean isMatch(String s, String p) {

        s = notNull(s);
        p = notNull(p);
        p = replace(p);

        int m = s.length();
        int n = p.length();

        boolean[][] match = new boolean[m+1][n+1];

        for (int i = 0; i <= m; ++i){
            for (int j = 0; j <=n; ++j) {
                boolean val = false;
                if(i == 0 && j == 0) {
                    val = true;
                } else if ( j > 0) {   //BUG: i > 0 && j > 0
                    char ch = p.charAt(j-1);
                    if( ch == '.' && i > 0 ) { // change to add i > 0
                        val = match[i-1][j-1];
                    } else if (ch == '*') {
                        char prev = p.charAt(j-2);
                        if( prev == '.') {
                            for (int k = i; k >= 0; k--) {
                                if(match[k][j-2]){
                                    val = true;
                                    break;
                                }
                            }
                        } else {
                            if( match[i][j-2] ) {
                                val = true;
                            } else {
                                for (int k = i; k > 0 && s.charAt(k-1) == prev; k--) {
                                    if(match[k-1][j-2]) {
                                        val = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } else if(i>0){ //change to add i > 0
                        val = match[i-1][j-1] && (ch == s.charAt(i-1));
                    }
                }
                match[i][j] = val;
            }
        }
        return match[m][n];
    }*/

    String notNull(String s) {
        return (null == s)?(""):(s);
    }

    public boolean isMatch(String s, String p) {
        s = notNull(s);
        p = notNull(p);

        int m = p.length();
        int n = s.length();

        boolean [][] match = new boolean[m+1][n+1];
        match[0][0] = true;

        for (int i = 1; i <=m; ++i) {
            for (int j = 0; j <=n; ++j) {
                char pCh = p.charAt(i-1);
                boolean val = false;

                switch(pCh) {
                    case '.' :
                        if (j > 0) { val = match[i-1][j-1];}
                        break;
                    case '*' :  // i >= 2, assuming no **
                        char prevCh = p.charAt(i-2);
                        if (prevCh == '.') {
                            val = match[i-2][j];
                            int k = j;//BUG: This is not simply match everything
                            while( !val && k > 0) {
                                val = match[i-2][k-1];
                                k--;
                            }
                        } else {
                            val = match[i-2][j];
                            int k = j;
                            while( !val && k > 0 && s.charAt(k-1) == prevCh) {
                                val = match[i-2][k-1];
                                //BUG: k--
                                k--;
                            }
                        }
                        break;
                    default: {
                        if (j > 0 && s.charAt(j-1) == pCh) {
                            val = match[i-1][j-1];
                        }
                    }
                }
                match[i][j] = val;
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "a"));
        System.out.println(sol.isMatch("aa", "aa"));
        System.out.println(sol.isMatch("aaa", "aa"));
        System.out.println(sol.isMatch("aa", "a*"));
        System.out.println(sol.isMatch("aa", ".*"));
        System.out.println(sol.isMatch("ab", ".*"));
        System.out.println(sol.isMatch("", ""));

        System.out.println(sol.isMatch("", "c*"));

        System.out.println(sol.isMatch("a", "c*a"));
        System.out.println(sol.isMatch("aa", "c*a*"));
        System.out.println(sol.isMatch("aab", "c*a*b"));
        System.out.println(sol.isMatch("aab", "b.*"));
    }
}
