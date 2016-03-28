package wr.leetcode.algo.palindrome_pairs;

import java.util.*;

public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ret = new HashSet<>();
        int n = words.length;
        Map<String, Integer> dict = dict(words);

        for (int i=0; i<n; ++i) {
            String w = words[i];
            int l = w.length();
            for (int k = 0; k <= l; ++k) {
                String left = w.substring(0, k);
                String right = w.substring(k);
                String rLeft = reverse(left);
                String rRight = reverse(right);

                if( isPalidrome(left) && dict.containsKey(rRight)) {
                    int x = dict.get(rRight);
                    if(x != i) {
                        ret.add(Arrays.asList(x, i));
                    }
                }
                if(isPalidrome(right) && dict.containsKey(rLeft)) {
                    int x = dict.get(rLeft);
                    if( x != i) {
                        ret.add(Arrays.asList(i, x));
                    }
                }
            }
        }
        return new LinkedList<>(ret);
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public Map<String, Integer> dict (String [] words) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String str = words[i];
            dict.put(str, i);
        }
        return dict;
    }

    public boolean isPalidrome(String str) {
        int l = 0;
        int r = str.length()-1;
        boolean ret = true;
        while( l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                ret = false;
                break;
            } else {
                l++;
                r--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String[] arr : new String[][] {
                {"abcd", "dcba", "lls", "s", "sssll"},
                {"bat", "tab", "cat"}
        }) {
            System.out.println(sol.palindromePairs(arr));
        }
    }
}