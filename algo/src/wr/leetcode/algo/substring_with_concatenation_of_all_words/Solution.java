package wr.leetcode.algo.substring_with_concatenation_of_all_words;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public boolean containsAll(String str,  Map<String, Integer> dict, int len) {
        boolean ret = true;
        int start = 0;
        while(!dict.isEmpty()) {
            String w = str.substring(start, start + len);
            if(!dict.containsKey(w)) {
                ret =false;
                break;
            } else {
                int cnt = dict.get(w) - 1;
                if(0 == cnt) {
                    dict.remove(w);
                } else {
                    dict.put(w, cnt);
                }
            }
            start += len;
        }
        return ret;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new LinkedList<>();
        if(null == s) {
            s = "";
        }
        if(null == words || 0 == words.length ) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        int n = s.length();
        int wLen = words[0].length();
        Map<String, Integer> ws = table(words);
        int totalLen = wLen * words.length;

        for (int i = 0; i + totalLen <= n; ++i) {
            Map<String, Integer> dict = new HashMap<>(ws);
            if (containsAll( s.substring(i, i+totalLen), dict, wLen)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public Map<String, Integer> table( String [] words) {
        Map<String, Integer> ret = new HashMap<>();
        for( String w : words) {
            Integer cnt = ret.getOrDefault(w, 0);
            ret.put(w, cnt + 1);
        }
        return ret;
    }





    /*
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

    public boolean isValid( String s, int start, Map<String, Integer> dict, int len, int size) {
        boolean ret;

        if( size * len + start > s.length()) {
            ret = false;
        } else {
            Map<String, Integer> load = new HashMap<>(dict);
            for (int i = 0; i < size; ++i) {
                int pos = start + i * len;
                String word = s.substring(pos, pos + len);
                if( !load.containsKey(word) ) {
                    break;
                } else {
                    int val = load.get(word) - 1;
                    if(val != 0) {
                        load.put(word, val);
                    } else {
                        load.remove(word);
                    }
                }
            }
            ret = load.isEmpty();
        }
        return ret;
    }

    public Map<String, Integer> buildMap(String[] words) {
        Map<String, Integer> dict = new HashMap<>();
        for (String w: words) {
            int val = dict.getOrDefault(w, 0) + 1;
            dict.put(w, val);
        }
        return dict;
    }


    public List<Integer> findSubstring(String s, String[] words) {
        if(null == s) {
            s = "";
        }
        if(null == words || words.length == 0) {
            throw new IllegalStateException("Invalid Input!");
        }

        List<Integer> ret = new LinkedList<>();
        int len = words[0].length();
        Map<String, Integer> dict = buildMap(words);
        for (int i = 0; i < s.length(); ++i) {
            if(isValid(s, i, dict, len, words.length)){
                ret.add(i);
            }
        }
        return ret;
    }
    */


    public static void main(String[] args) {
        Solution sol = new Solution();
        /*String S="goodgoodbestword";
        String [] arr = {"word", "good","good", "best"};*/
        String S="barfoothefoobarman";
        String [] arr = {"foo", "bar"};
        System.out.println(sol.findSubstring(S, arr));
    }
}