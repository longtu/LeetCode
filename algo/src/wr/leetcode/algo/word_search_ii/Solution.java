package wr.leetcode.algo.word_search_ii;

import java.util.*;

/**
 * use array to implment Trie for better performance!!!
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> stringSet = new HashSet<>();
        if(null != words && null != board && board.length != 0 && board[0].length != 0) {
            Trie trie = dict(words);
            for (int r = 0; r < board.length; ++r)
                for (int c = 0; c < board[0].length; ++c) {
                    dfsSearchWord(trie, board, new HashSet<>(), r, c, new LinkedList<>(), stringSet);
                }

        }
        return new LinkedList<>(stringSet);
    }

    private Trie dict(String [] words) {
        Trie dict = new Trie();
        for (String w : words) {
            dict.insert(w);
        }
        return dict;
    }

    private String string(List<Character> path) {
        StringBuilder sb = new StringBuilder();
        for(Character ch : path) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private void dfsSearchWord(Trie dict, char[][] board, Set<Integer> visited, int row, int col , LinkedList<Character> path,
                                  Set<String> found) {
        int cols = board[0].length;
        int key = row * cols + col;
        if(visited.contains(key)) {
            return;
        }
        visited.add(key);
        path.addLast(board[row][col]);
        String str = string(path);
        if(dict.search(str)){
            found.add(str);
        }

        if(dict.startsWith(str)){
            if(row > 0) {
                dfsSearchWord(dict, board, visited, row-1, col, path, found);
            }
            if(row < board.length-1) {
                dfsSearchWord(dict, board, visited, row+1, col, path, found);
            }
            if(col > 0) {
                dfsSearchWord(dict, board, visited, row, col-1, path, found);
            }
            if(col < board[0].length -1) {
                dfsSearchWord(dict, board, visited, row, col+1, path, found);
            }
        }
        path.removeLast();
        visited.remove(key);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String [] words = {"oath","pea","eat","rain"};

        System.out.println(sol.findWords(board, words));

    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;

    public TrieNode() {
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = node.children[ch-'a'];
            if(null == child) {
                child = new TrieNode();
                node.children[ch-'a'] = child;
            }
            node = child;
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = node.children[ch-'a'];
            if(null == child) {
                return false;
            }
            node = child;
        }
        return node.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            TrieNode child = node.children[ch - 'a'];
            if(null == child) {
                return false;
            }
            node = child;
        }
        return true;
    }
}
