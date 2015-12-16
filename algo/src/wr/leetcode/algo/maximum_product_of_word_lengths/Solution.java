package wr.leetcode.algo.maximum_product_of_word_lengths;



public class Solution {
    public int maxProduct(String[] words) {
        if(null == words) {
            words = new String[0];
        }
        int n = words.length;

        int[][] dict = new int[n][26];

        int maxP = 0;
        for (int i = 0; i < n; ++i) {
            String word = words[i];
            for(int j = 0; j < word.length(); ++j) {
                int index = word.charAt(j) - 'a';
                dict[i][index] += 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if(!overlaps(dict[i], dict[j])){
                    int p = words[i].length() * words[j].length();
                    if(p > maxP) {
                        maxP = p;
                    }
                }
            }
        }
        return maxP;
    }

    private boolean overlaps(int[] left, int[] right) {
        boolean ret = false;
        for (int i = 0; i < 26; ++i) {
            if (left[i] != 0 && right[i] != 0) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String tests [][] = {
                {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"},
                {"a", "ab", "abc", "d", "cd", "bcd", "abcd"},
                {"a", "aa", "aaa", "aaaa"},
        };

        for (String[] test : tests) {
            System.out.println(sol.maxProduct(test));
        }
    }
}
