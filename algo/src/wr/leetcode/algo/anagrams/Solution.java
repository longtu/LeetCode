package wr.leetcode.algo.anagrams;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs) {
            strs = new String[0];
        }
        Map<String, Queue<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = keyOfStr(str);
            Queue<String> list = map.getOrDefault(key, new PriorityQueue<>());
            list.add(str);
            map.put(key, list);
        }

        return map.values().stream()
                .map((e) -> (toList(e)))
                .collect(Collectors.toList());
    }

    public List<String> toList( Queue<String> list) {
        LinkedList<String> ret= new LinkedList<>();
        while(!list.isEmpty()) {
            ret.add(list.remove());
        }
        return ret;
    }

    public String keyOfStr(String str) {
        Map<Character, Integer> dict = new TreeMap<>();

        for (char ch : str.toCharArray()) {
            int val = dict.getOrDefault(ch, 0) + 1;
            dict.put(ch, val);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : dict.keySet()) {
            sb.append(ch);
            sb.append(dict.get(ch));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"chi","nip","lab","mud","fan","yak","kid","lox","joy","rob","cad","hug","ken","oaf","pus","hos","ton","any","sac","mid","nip","ron","tux","set","jug","axe","ago","sob","ode","dot","nit","pug","sue","new","rub","sup","ohs","ski","oaf","don","cob","kin","ark","gay","jay","bur","dot","eat","rca","wad","maj","luz","gad","dam","eon","ark","del","sin","tat"};
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(arr));
    }
}