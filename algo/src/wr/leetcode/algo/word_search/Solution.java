package wr.leetcode.algo.word_search;

public class Solution {

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

}
