public class Solution {
    private Integer getIndex(int x, int y, int width) {
        return y * width + x;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return (word.length() == 0);

        int width = board[0].length;
        char[] arr = word.toCharArray();
        Set<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < width; ++j) {
                if (dfsSearch(board, arr, j, i, visited))
                    return true;
            }
        return false;
    }

    boolean dfsSearch(char[][] board, char[] arr, int x, int y,
            Set<Integer> visited) {

        int matched = visited.size();
        if (matched == arr.length)
            return true;

        int width = board[0].length;
        int index = getIndex(x, y, width);
        if (visited.contains(index))
            return false;

        char value = getCharValue(x, y, board);
        if (value == 0 || value != arr[matched])
            return false;
        visited.add(getIndex(x, y, width));

        boolean ret = (dfsSearch(board, arr, x - 1, y, visited)
                || dfsSearch(board, arr, x + 1, y, visited)
                || dfsSearch(board, arr, x, y - 1, visited) || dfsSearch(board,
                arr, x, y + 1, visited));
        visited.remove(getIndex(x, y, width));
        return ret;
    }

    char getCharValue(int x, int y, char[][] board) {
        if (y < 0 || y >= board.length)
            return 0;
        if (x < 0 || x >= board[0].length)
            return 0;
        return board[y][x];
    }

}

