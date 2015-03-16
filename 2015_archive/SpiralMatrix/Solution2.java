public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0)
            return null;
        
        int [][] res = new int[n][n];
        for(int i = 0; i < n; i++)
            res[i] = new int[n];
        fillSpiral(res, 0, 0, n, 1);
        return res;
    }

    void fillSpiral(int [][] matrix, int startX, int startY, int size, int value){
        if(size == 0)
            return;
        if(size == 1)
            matrix[startX][startY] = value;

        for (int x = startX; x<size-1+startX; ++x)
            matrix[startY][x] = value++;

        for (int y = startY; y<size-1+startY; ++y)
            matrix[y][startX] = value++;

        for (int x = startX+size-1; x > startX; --x)
            matrix[startY+size-1][x] = value++;

        for (int y = startY+size-1; y > startY; --y)
            matrix[y][startX+size-1] = value++;
        
        fillSpiral(matrix, startX+1, startY-1, size -2, value);
    }
}
