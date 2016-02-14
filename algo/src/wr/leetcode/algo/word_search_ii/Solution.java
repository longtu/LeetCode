package wr.leetcode.algo.word_search_ii;

import java.util.*;

public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<>();
        if (null != words && words.length > 0 && null != board && board.length > 0 && board[0].length > 0 ) {
            int m = board.length;
            int n = board[0].length;
            Trie dict = buildDict(words);
            for (int i = 0; i < m ; ++ i) {
                for (int j = 0; j < n; ++j) {
                    boolean[][] visited = new boolean[m][n];
                    Pos pos = new Pos(i,j);
                    ret.addAll(wordSearch(board, pos, dict, visited, ""));
                }
            }
        }
        return new LinkedList<>(ret);
    }

    public Set<String> wordSearch(char[][] board, Pos pos, Trie dict, boolean[][] visited, String path) {
        Set<String> ret = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        int x = pos.x;
        int y = pos.y;
        char ch = board[x][y];
        path = path + ch;
        if (!visited[x][y]) {
            visited[x][y] = true;
            if (dict.hasPrefix(path)) {
                int [] dr = {-1, 0, 0, 1};
                int [] dc = { 0, -1, 1, 0};
                for (int i = 0; i < 4; ++i) {
                    int nx = pos.x + dr[i];
                    int ny = pos.y + dc[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        Pos next = new Pos(nx,ny);
                        ret.addAll(wordSearch(board,next,dict,visited, path));
                    }
                }
                if (dict.hasWord(path)) {
                    ret.add(path);
                }
            }
            visited[x][y] = false;
        }
        return ret;
    }

    public Trie buildDict( String [] words ) {
        Trie dict = new Trie();
        for (String w : words) {
            dict.add(w);
        }
        return dict;
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
class Trie {
    TrieNode root = new TrieNode();

    public void add(String word) {
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

    public boolean hasPrefix(String prefix) {
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

    public boolean hasWord(String word) {
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
*/

class TrieNode {
    boolean isTail = false;
    TrieNode [] children = new TrieNode[26];
    public boolean hasChildren() {
        boolean ret = false;
        for (int j = 0; j < 26; ++j) {
            if( null != children[j]){
                ret = true;
                break;
            }
        }
        return ret;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public boolean hasPrefix(String prefix) {
        TrieNode node = findNode(prefix);
        return (null != node && node.hasChildren());
    }

    public boolean hasWord(String word) {
        TrieNode node = findNode(word);
        return (null != node && node.isTail);
    }

    public TrieNode findNode(String word) {
        TrieNode ret = null;
        TrieNode node = root;
        word = (null == word) ? ("") : (word);
        for (int i = 0; i <= word.length(); ++i) {
            if (i == word.length()) {
                ret = node;
                continue;
            }
            char ch = word.charAt(i);
            TrieNode child = node.children[ch - 'a'];
            if (null == child) {
                break;
            } else {
                node = child;
            }
        }
        return ret;
    }

    public void add(String word) {
        TrieNode node = root;
        word = (null == word) ? ("") : (word);
        for (int i = 0; i <= word.length(); ++i) {
            if (i == word.length()) {
                node.isTail = true;
                continue;
            }
            char ch = word.charAt(i);
            TrieNode child = node.children[ch - 'a'];
            if (null == child) {
                child = new TrieNode();
                node.children[ch - 'a'] = child;
            }
            node = child;
        }
    }
}



