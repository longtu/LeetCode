package wr.leetcode.algo.word_search_ii;

import java.util.*;

public class Solution {
    //duplicates!!!!!!
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<>();
        if( null != board && board.length > 0 && board[0].length > 0 && null != words
                && words.length > 0 ) {
            int m = board.length;
            int n = board[0].length;

            Trie trie = new Trie();
            for (String w : words){
                trie.insert(w);
            }

            for (int i = 0; i < m; ++i){
                for (int j = 0; j < n; ++j) {
                    //ARRAY IS MORE PERFORMANCE FIRENDLY HERE for visited map
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    ret.addAll(findWordsRec(board, trie, new Pos(i, j), visited, ""));
                }
            }
        }
        //BUG: ONLY FINAL RET CONVER TO LIST
        return new LinkedList<>(ret);
    }

    //BUG: DO NOT COPY LIST TO SET OVER AND OVER AGAIN
    public Set<String> findWordsRec(char[][] board, Trie trie, Pos pos, boolean[][] visited, String path) {
        int m = board.length;
        int n = board[0].length;
        int x = pos.x;
        int y = pos.y;
        char ch = board[x][y];
        String word = path + ch;
        //BUG: REMOVE Duplidates !!!!
        Set<String> ret = new HashSet<>();
        int key = x*n + y;

        if(!visited[x][y]) {
            visited[x][y] = true;
            if( trie.search(word)){
                ret.add(word);
            }
            // not else as we may have word as prefix of others
            if(trie.startsWith(word)) {
                int [] xdiff = {0, -1, 1, 0};
                int [] ydiff = {-1, 0, 0, 1};
                for (int i = 0; i < 4; ++i ) {
                    int r = xdiff[i] + x;
                    int c = ydiff[i] + y;
                    if( r >= 0 && r < m && c >= 0 && c < n){
                        ret.addAll(findWordsRec(board, trie, new Pos(r, c), visited, word));
                    }
                }
            }
            visited[x][y] = false;
        }
        return ret;
    }

    class Pos {
        int x;
        int y;

        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            if( null != word) {
                TrieNode node = root;
                int n = word.length();
                for (int i = 0; i < n; ++i) {
                    char ch = word.charAt(i);
                    int index = ch - 'a';
                    if(null == node.children[ index ]) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                    if( i == n-1) {
                        node.isTail = true;
                    }
                }
            }
        }

        public boolean startsWith(String prefix) {
            boolean ret = false;
            if(null != prefix) {
                TrieNode node = root;
                int n = prefix.length();
                for (int i = 0; i < n; ++i) {
                    char ch = prefix.charAt(i);
                    int index = ch - 'a';
                    node = node.children[index];
                    if(null == node) {
                        break;
                    }
                    if( n-1 == i) {
                        //BUG j < 26 instead of 27
                        for (int j = 0; j < 26; ++j) {
                            if( null != node.children[j]){
                                ret = true;
                                break;
                            }
                        }
                    }
                }
            }
            return ret;
        }

        public boolean search(String word) {
            boolean ret = false;
            if( null != word ) {
                TrieNode node = root;
                int n = word.length();
                for ( int i = 0; i < n; ++i) {
                    char ch = word.charAt(i);
                    int index = ch - 'a';
                    node = node.children[index];
                    if( null == node ) {
                        break;
                    }
                    if( n-1 == i ) {
                        ret = node.isTail;
                    }
                }
            }
            return ret;
        }
    }

    class TrieNode {
        boolean isTail = false;
        TrieNode [] children = new TrieNode[26];
    }


    /*
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<>();
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        if (!(null == board || 0 == board.length || 0 == board[0].length)) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int j = 0; j < board.length; ++j)
                for (int i = 0; i < board[0].length; ++i) {
                    ret.addAll(dfs(board, visited, trie, "", i, j));
                }
        }
        return new LinkedList<>(ret);
    }

    public Set<String> dfs(char[][] board, boolean[][] visited, Trie trie, String prefix, int i, int j) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        Set<String> ret = new HashSet<>();

        if (visited[j][i]) {
            return ret;
        }
        visited[j][i] = true;
        String word = prefix + board[j][i];

        if (trie.search(word)) {
            ret.add(word);
        }

        for (int k = 0; k < 4; ++k) {  //BUG: 4 neighbours instead of 8
            int x = i + dx[k];
            if (x < 0 || x >= board[0].length) {
                continue;
            }
            int y = j + dy[k];
            if (y < 0 || y >= board.length) {
                continue;
            }
            if (trie.startsWith(word)) {
                ret.addAll(dfs(board, visited, trie, word, x, y));
            }
        }
        visited[j][i] = false;
        return ret;
    }


    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";

        // Initialize your data structure here.
        public TrieNode() {
        }
    }*/
}


