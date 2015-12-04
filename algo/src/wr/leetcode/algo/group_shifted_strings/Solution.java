package wr.leetcode.algo.group_shifted_strings;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strings) {
            String key = toFirst(str);
            List<String> group = groups.getOrDefault(key, new LinkedList<>());
            group.add(str);
            groups.put(key, group);
        }

        groups.entrySet().stream()
            .map(Map.Entry::getValue)
            .forEach(Collections::sort);

        return groups.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public String toFirst( String str) {

        StringBuilder sb = new StringBuilder();
        if(null != str && !str.isEmpty()) {
            char base = str.charAt(0);
            int dist = base - 'a'; // 0<=dist<26

            for (char ch : str.toCharArray()) {
                int c = ch - dist;
                if( c < 'a') {
                    c += 26;
                }
                sb.append( (char)(c) );
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> groups = sol.groupStrings(
                new String[]{ "xyz", "abc", "bcd", "acef", "az", "ba", "a", "z"}
        );

        System.out.println(groups);
    }
}
