package wr.leetcode.algo.palindrome_permutation_ii;


import java.util.*;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ret = new LinkedList<>();

        Map<Character, Integer> dict = dict(s);
        List<Character> odds = new LinkedList<>();
        for ( char ch : dict.keySet()) {
            int val = dict.get(ch);
            if(1 == val %2) {
                odds.add(ch);
            }
        }

        if (odds.size() <= 1) {
            Character odd = null;
            if(1 == odds.size()) {
                odd = odds.get(0);
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : dict.keySet()) {
                //GOOD: handling odds by /=2
                int cnt = dict.get(ch)/2;
                if( cnt > 0) {
                    while (cnt-- > 0) {
                        sb.append(ch);
                    }
                }
            }
            Set<String> halves = generateLeftHalves(sb.toString());
            Set<String> palindromes = new HashSet<>();
            for (String half : halves ) {
                String p = half +  ((null == odd)? (""):(odd)) + reverse(half);
                palindromes.add(p);
            }
            ret = new LinkedList<>(palindromes);
        }
        return ret;
    }

    private String reverse( String str ) {
        return new StringBuilder(str).reverse().toString();
    }

    //GOOD: generate half and then create mirror
    private Set<String> generateLeftHalves(String str) {
        Set<String> ret = new HashSet<>();
        if(str.isEmpty()) {
            ret.add("");
        } else {
            char ch = str.charAt(0);
            Set<String> subs = generateLeftHalves(str.substring(1, str.length()));
            for (String sub : subs) {
                int n = sub.length();
                for (int i = 0; i <= n; ++i ) {
                    String s = sub.substring(0, i) + ch + sub.substring(i, n);
                    ret.add(s);
                }
            }
        }
        return ret;
    }

    private Map<Character, Integer> dict(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        s = (null == s) ? (""):(s);
        for (char ch : s.toCharArray()) {
            int cnt = dict.getOrDefault(ch, 0) + 1;
            dict.put(ch, cnt);
        }
        return dict;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "aabb", "abc", "", "a", "aaabb"
        } ) {
            System.out.println(sol.generatePalindromes(str));
        }
    }
}
