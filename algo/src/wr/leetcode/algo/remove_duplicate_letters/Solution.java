package wr.leetcode.algo.remove_duplicate_letters;



import java.util.*;
import java.util.stream.Collectors;


public class Solution {


    //Method1: Greedy O(N*K) k: count of unique characters
    public String removeDuplicateLetters0(String s) {
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            Map<Character, Integer> dict = dict(s);
            char smallest = 'z'+1;
            int smallestIndex = -1;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if ( ch < smallest ) {
                    smallest = ch;
                    smallestIndex = i;
                }
                //BUG: check char count instead of smallest
                if( dict.get(ch) == 1) {
                    break;
                }
                //BUG: update count of ch instead of smallest
                dict.put(ch, dict.get(ch)-1);
            }
            sb.append(smallest);
            //BUG: next of smallestIndex
            s = s.substring(smallestIndex+1).replaceAll(String.valueOf(smallest), "");
        }
        return sb.toString();
    }

    //Method2: Use stack to store chars in result and current smallest
    public String removeDuplicateLetters(String s) {
        if(null == s) {
            s = "";
        }

        Map<Character, Integer> dict = dict(s);
        Set<Character> inResult = new HashSet<>();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            dict.put(ch, dict.get(ch)-1);
            if( inResult.contains(ch)) {
                continue;
            }
            //BUG:
            while(!st.isEmpty() && st.peek() > ch && dict.get(st.peek()) > 0) {
                inResult.remove(st.pop());
            }
            st.push(ch);
            inResult.add(ch);
        }
        return st.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }


    private Map<Character, Integer> dict(String s) {

        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int cnt = dict.getOrDefault(ch, 0) + 1;
            dict.put(ch, cnt);
        }
        return dict;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (String str : new String[] {
                "bcabc",
                "cbacdcbc",
                "bcabc",
                "bcbac"
        }) {
            System.out.println(sol.removeDuplicateLetters(str));
        }
    }


}
