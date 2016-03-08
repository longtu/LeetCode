package wr.leetcode.algo.edit_distance;

public class Solution {


    public int minDistance(String word1, String word2) {
        word1 = notNull(word1);
        word2 = notNull(word2);
        int m = word1.length();
        int n = word2.length();

        int [][] dist = new int[3][n+1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <=n; ++j) {
                int val;
                if(i == 0 && j == 0) {
                    val = 0;
                } else {
                    val =Integer.MAX_VALUE;
                    if( i > 0) {
                        val = Math.min(val, dist[(i-1)%3][j] + 1);
                    }
                    if( j > 0) {
                        val = Math.min(val, dist[i%3][j-1] + 1);
                    }
                    if(i > 0 && j > 0) {
                        val = Math.min(val,
                            dist[(i-1)%3][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1))?(0):(1)) );
                    }
                }
                dist[i%3][j] = val;
            }
        }
        return dist[m%3][n];
    }

    public int minDistance0(String word1, String word2) {
        word1 = notNull(word1);
        word2 = notNull(word2);

        int m = word1.length();
        int n = word2.length();
        int [][] dist = new int[m+1][n+1];

        for (int i = 0; i <=m; ++i){
            for (int j = 0; j <=n; ++j) {
                int val;
                if (i == 0 && j == 0) {
                    val = 0;
                } else if (i == 0) {
                    val = j;
                } else if (j == 0) {
                    val = i;
                } else {
                    val = ((word1.charAt(i-1) == word2.charAt(j-1))?(0):(1)) + dist[i-1][j-1];
                    val = Math.min(val, dist[i-1][j]+1);
                    val = Math.min(val, dist[i][j-1]+1);
                }
                dist[i][j] = val;
            }
        }

        return dist[m][n];
    }

    private String notNull(String str) {
        return (null == str)?(""):(str);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minDistance("a", "ab"));
        System.out.println(sol.minDistance0("a", "ab"));
    }
}
