package wr.leetcode.algo.airbnb;

public class RegularExpressionMatching {
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
                    case '*' :  // i >= 2, assuming no **, *+, +*
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
                    case '+' :  // i >= 2, assuming no ++ or +*, *+
                        prevCh = p.charAt(i-2);
                        if (prevCh == '.') {
                            int k = j;
                            while( !val && k > 0) {
                                val = match[i-2][k-1];
                                k--;
                            }
                        } else {
                            int k = j;
                            while( !val && k > 0 && s.charAt(k-1) == prevCh) {
                                val = match[i-2][k-1];
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
        RegularExpressionMatching sol = new RegularExpressionMatching();
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

        System.out.println(sol.isMatch("a", "b+"));
        System.out.println(sol.isMatch("a", "a+"));
        System.out.println(sol.isMatch("aa", "a+"));
        System.out.println(sol.isMatch("aaa", "a+"));
        System.out.println(sol.isMatch("baaa", "a+"));

        System.out.println(sol.isMatch("a", "aa+"));
        System.out.println(sol.isMatch("abc", "ab.+"));
        System.out.println(sol.isMatch("abc", "ac.+"));
        System.out.println(sol.isMatch("abc", "abc.+"));
        System.out.println(sol.isMatch("abcd", "abc.+"));
        System.out.println(sol.isMatch("abcdef", "abc.+"));
        System.out.println(sol.isMatch("abcccc", "abc.+"));
    }
}
