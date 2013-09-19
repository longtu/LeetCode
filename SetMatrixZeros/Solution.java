public class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 )
            return;
        
        int height = matrix.length;
        int width = matrix[0].length;
        if(height == 1 || width == 1)
            return;

       for(int i = 0; i < height; ++i)
          for(int j = 0; j< width; ++j){
             if(matrix[i][j] == 0) {
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            } 
          }
        
        for(int i = 0; i < height; ++i) {
            if(matrix[i][0] == 0){
                for(int j = 0; j< width; ++j)
                    matrix[i][j] = 0;
            }
        }

        for(int j = 0; j< width; ++j){
            if(matrix[0][j] == 0) {
                for(int i = 0; i < height; ++i)
                    matrix[i][j] = 0;
            }
        }
    }
}

