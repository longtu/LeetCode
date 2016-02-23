package wr.leetcode.algo.wildcard_matching;

public class Solution {

    /*
    public String notNull(String ret) {
        return (null == ret)?(""):(ret);
    }

    public String replace(String str) { return str.replaceAll("\\*+", "*"); }

    public boolean isMatch(String s, String p) {

        s = notNull(s);
        p = notNull(p);
        p = replace(p); //Replace is important!!!

        int m = s.length();
        int n = p.length();

        boolean [][] match = new boolean[m+1][n+1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++ j) {
                boolean val = false;
                if( 0 == i && 0 == j) {
                    val = true;
                } else if(j > 0) { //GOOD: j at least one
                    char ch = p.charAt(j-1);
                    if( '?' == ch && i > 0) {
                        val = match[i-1][j-1];
                    } else if ('*'== ch) { // j >=2
                        for (int k = i; k >=0; --k) {
                            if (match[k][j-1]){
                                val = true;
                                break;
                            }
                        }
                    } else if ( i > 0 ) { //j has character -- has to be normal ones
                        val = match[i-1][j-1] && ch == s.charAt(i-1);
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
                    case '?' :
                        if (j > 0) { val = match[i-1][j-1];}
                        break;
                    case '*' :
                        val = match[i-1][j];
                        int k = j;
                        while( !val && k > 0) {
                            val = match[i-1][k-1];
                            k--;
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

        String[][] inputs = {
            {"aa", "a"},
            {"aa", "aa"},
            {"aaa", "aa"},
            {"aa", "*"},
            {"aa", "a*"},
            {"ab", "?*"},
            {"aab", "c*a*b"},
           {"aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"},
        };


        for (String[] i : inputs) {
            System.out.println(sol.isMatch(i[0], i[1]));
        }

    }

}
