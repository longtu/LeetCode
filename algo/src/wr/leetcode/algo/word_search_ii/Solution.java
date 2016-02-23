package wr.leetcode.algo.word_search_ii;

import java.util.*;

public class Solution {
/*
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
public List<String> findWords(char[][] board, String[] words) {
    Set<String> found = new HashSet<>();
    if(null != board && board.length > 0 && board[0].length > 0 && null != words
            && words.length > 0) {
        int m = board.length;
        int n = board[0].length;
        Trie dict = new Trie();
        for (String w : words){
            dict.add(w);
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfsSearch(board, dict, i, j, found, visited, "");
            }
        }
    }
    return new LinkedList<>(found);
}

    public void dfsSearch (char[][] board, Trie dict, int x, int y, Set<String> found, boolean[][] visited, String prefix ) {
        int [] dx = {-1, 0, 0, 1};
        int [] dy = {0, -1, 1, 0};
        int m = board.length;
        int n = board[0].length;

        if (!visited[x][y]) {
            visited[x][y] = true;
            String w = prefix + board[x][y];
            if (dict.searchWord(w)) {
                found.add(w);
            }

            if (dict.searchPrefix(w)) {
                for (int i = 0; i < 4; ++i) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (nx >=0 && nx <m && ny >=0 && ny < n) {
                        dfsSearch(board, dict, nx, ny, found, visited, w);
                    }
                }
            }
            visited[x][y] = false;
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isTail;

    public TrieNode () {
        children = new TrieNode[26];
        isTail = false;
    }
}

class Trie{
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String w) {
        w = (null == w)?(""):(w);
        int n = w.length();
        TrieNode node = root;

        for (int i = 0; i <= n; ++i) {
            if (n == i) {
                node.isTail = true;
            } else {
                char ch = w.charAt(i);
                int key = ch - 'a';
                TrieNode child = node.children[key];
                if( null == child ) {
                    child = new TrieNode();
                    node.children[key] = child;
                }
                node = child;
            }
        }
    }

    public boolean searchWord(String w) {
        TrieNode node = find(w);
        return (null != node) && node.isTail;
    }

    public boolean searchPrefix(String w) {
        TrieNode node = find(w);
        boolean ret = false;
        if (null != node) {
            for (int ch = 0; ch < 26; ++ch) {
                if (null != node.children[ch]) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    private TrieNode find(String w) {
        w = (null == w)?(""):(w);
        int n = w.length();
        TrieNode node = root;
        TrieNode ret = null;
        for (int i = 0; i <= n; ++i) {
            if (n == i) {
                ret = node;
            } else {
                char ch = w.charAt(i);
                int key = ch - 'a';
                TrieNode child = node.children[key];
                if( null == child ) {
                    break;
                }
                node = child;
            }
        }
        return ret;
    }
}



