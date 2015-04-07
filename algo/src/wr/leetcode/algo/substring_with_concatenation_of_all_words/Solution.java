package wr.leetcode.algo.substring_with_concatenation_of_all_words;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new LinkedList();
        if(null == S || S.length() == 0 || null == L || L.length == 0 ) {
            return ret;
        }
        int wordLen = L[0].length();
        Map<String, Integer> dict = buildDict(L);
        Set<Integer> candidates = findStarts(S, dict, wordLen, L.length);
        System.out.println(candidates);
        for ( Integer start : candidates) {
            if(isMatch(start,dict,candidates,wordLen,S, L.length)){
                ret.add(start);
            }
        }
        return ret;
    }

    public Map<String, Integer> buildDict(String[] T) {
        Map<String, Integer> dict= new HashMap();
        for (String s : T) {
            dict.put(s, dict.getOrDefault(s, 0) + 1);
        }
        return dict;
    }

    public Set<Integer> findStarts(String S, Map<String, Integer> dict, Integer len, int steps) {
        Set<Integer> ret = new HashSet();
        for (int i = 0; i + steps*len <= S.length(); ++i) {
            if(dict.containsKey(S.substring(i, i + len))) {
                ret.add(i);
            }
        }
        return ret;
    }

    public boolean isMatch(int start, Map<String, Integer> d, Set<Integer> candidates, Integer len, String S, int step) {
        Map<String, Integer> dict = new HashMap(d);
        for (int i = 0; i < step; ++ i) {
            int pos = start + i*len;
            String key = S.substring(pos, pos+len);
            if(!dict.containsKey(key) || dict.get(key) <= 0){
                return false;
            }
            dict.put(key, dict.get(key)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S="a";
        String [] arr = {"a"};
        System.out.println(sol.findSubstring(S, arr));
    }
}