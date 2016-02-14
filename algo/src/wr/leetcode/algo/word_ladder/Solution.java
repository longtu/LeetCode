package wr.leetcode.algo.word_ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if ( null == wordList ) {
            wordList = new HashSet<>();
        }
        wordList.add(beginWord);
        wordList.add(endWord);

        int ret = 0;
        Map<String, List<String>> conn = connectivity(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> nextQ = new LinkedList<>();

        nextQ.offer(beginWord);
        visited.add(beginWord);

        //RETURN IS LENGTH INSTEAD OF EDGES
        int step = 0;
        while(!nextQ.isEmpty()) {
            step++;
            Queue<String> q = nextQ;
            nextQ = new LinkedList<>();
            while(!q.isEmpty()) {
                String n = q.poll();
                if(n.equals(endWord)) {
                    ret = step;
                    break;
                }
                List<String> neighbours = conn.getOrDefault(n, new LinkedList<>());
                for ( String neighbour : neighbours ) {
                    if (!visited.contains(neighbour)) {
                        nextQ.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return ret;
    }

    public Map<String, List<String>> connectivity( Set<String> words ) {
        Map<String, List<String>> conn = new HashMap<>();
        for (String w : words) {
            List<String> neighbours = new LinkedList<>();
            StringBuilder sb = new StringBuilder(w);

            for (int i = 0; i < w.length(); ++i) {
                char ch = w.charAt(i);
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (ch != c) {
                        sb.setCharAt(i, c);
                        String neighbour = sb.toString();
                        if (words.contains(neighbour)) {
                            neighbours.add(neighbour);
                        }
                    }
                }
                //BUG: RESET SB !!!!!
                sb.setCharAt(i, ch);
            }
            conn.put(w, neighbours);
        }
        return conn;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> words = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(sol.ladderLength("hit", "cog", words));
    }
}