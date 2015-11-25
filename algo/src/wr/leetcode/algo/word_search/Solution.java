package wr.leetcode.algo.word_search;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    class Pos {
        int x;
        int y;

        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean ret = false;
        if( null != board && board.length > 0 && board[0].length > 0
                && null != word && !word.isEmpty()) {
            int m = board.length;
            int n = board[0].length;
            Set<Integer> visited = new HashSet<>();

            char ch = word.charAt(0);
            for (int i = 0; i < m && !ret; ++i){
                for (int j = 0; j < n && !ret ; ++j) {
                    if( board[i][j] == ch && exist(board, word, visited, new Pos(i,j), "")) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    public boolean exist(char[][] board, String word, Set<Integer> visited, Pos pos, String path) {
        boolean ret = false;
        int m = board.length;
        int n = board[0].length;
        char ch = board[pos.x][pos.y];
        String str = path + ch;
        int key = n * pos.x + pos.y;

        if(!visited.contains(key)) {
            visited.add(key);
            if( word.equals(str) ) {
                ret = true;
            } else if( str.length() < word.length()) {
                char nextCh = word.charAt(str.length());
                int[] xdiff = {0, -1, 1, 0};
                int[] ydiff = {-1, 0, 0, 1};
                for (int i = 0; i < 4; ++i) {
                    int x = pos.x + xdiff[i];
                    int y = pos.y + ydiff[i];

                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == nextCh
                        && exist(board, word, visited, new Pos(x, y), str)) {
                        return true;
                    }
                }
            }
            visited.remove(key);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(sol.exist(board, "ABCCED"));
        System.out.println(sol.exist(board, "SEE"));
        System.out.println(sol.exist(board, "ABCB"));

    }

    /*
    public boolean exist(char[][] board, String word) {
        if(null == board || board.length == 0 || board[0] == null) {
            return (null == word || word.equals(""));
        }

        boolean ret = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; ++ x){
            for (int y = 0; y < board[0].length; ++y){
                if(exist(board, visited, x, y, word)){
                    ret = true;
                }
            }
        }
        return ret;
    }

    public boolean exist(char[][] board, boolean[][] visited,
        int x, int y, String word) {
        if(null == word || word.equals("") ) {
            return true;
        }
        if(visited[x][y] || word.charAt(0) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean ret = false;
        String nextWord = word.substring(1);
        if(x > 0 && !ret){
            ret = exist(board, visited, x-1, y, nextWord);
        }

        if(x < board.length-1 && !ret){
            ret = exist(board, visited, x+1, y, nextWord);
        }

        if(y > 0 && !ret){
            ret = exist(board, visited, x, y-1, nextWord);
        }

        if(y < board.length-1 && !ret){
            ret = exist(board, visited, x, y+1, nextWord);
        }
        visited[x][y] = false;
        return ret;
    }*/

}
