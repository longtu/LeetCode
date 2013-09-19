public class Solution {
	public void setZeroes(int[][] matrix) {

		if(matrix == null || matrix.length == 0 )
			return;

		int height = matrix.length;
		int width = matrix[0].length;

		int firstRow = 1;
		for(int j = 0; j< width; ++j){
			if(matrix[0][j] == 0) {
				firstRow = 0;
				break;
			}
		}
		int firstCol = 1;
		for(int i = 0; i< height; ++i){
			if(matrix[i][0] == 0) {
				firstCol = 0;
				break;
			}
		}

		for(int i = 0; i < height; ++i)
			for(int j = 0; j< width; ++j){
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				} 
			}
		for(int i = 1; i < height; ++i) {
			for(int j = 1; j< width; ++j){
				if(matrix[i][0] == 0 || matrix[0][j]==0 )
					matrix[i][j] = 0;
			}
		}

		if(firstCol ==0 ){
			for(int i = 0; i< height; ++i)
				matrix[i][0] = 0;
		}
		if(firstRow ==0 ){
			for(int j = 0; j< width; ++j)
				matrix[0][j] = 0;
		}
	}
}

