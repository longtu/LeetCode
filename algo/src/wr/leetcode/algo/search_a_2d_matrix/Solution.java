package wr.leetcode.algo.search_a_2d_matrix;

public class Solution {
    /*
    public boolean searchMatrix(int[][] matrix, int target) {

        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int row = -1;
        while(rowMin <= rowMax) {
            int mid = rowMin + ((rowMax - rowMin)>>1);
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] > target){
                rowMax = mid - 1;
            } else {
                rowMin = mid + 1;
                row = mid;
            }
        }
        if(row < 0 || row > matrix.length - 1) {
            return false;
        }
        int start = 0;
        int end = matrix[row].length-1;

        while(start <= end){
            int mid = start + ((end-start)>>1);
            if(matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }*/

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ret = false;
        if( null != matrix && matrix.length > 0 && matrix[0].length > 0) {
            int start = 0;
            int end = matrix.length - 1;
            int found = -1;
            while( start <= end ) {
                int mid = start + ((end - start)>>1);
                int mv = matrix[mid][0];
                if(mv == target) {
                    ret = true;
                    break;
                } else if(mv < target) {
                    start = mid + 1;
                    found = mid;
                } else {
                    end = mid - 1;
                }
            }
            if(!ret && found != -1) {
                ret = search(matrix[found], target);
            }
        }
        return ret;
    }

    public boolean search(int[] nums, int target) {
        boolean ret = false;
        if ( null != nums && 0 != nums.length) {
            int start = 0;
            int end = nums.length - 1;
            while( start <= end ) {
                int mid = start + ( (end - start) >> 1);
                int mv = nums[mid];
                if( mv == target ) {
                    ret = true;
                    break;
                } else if (mv < target ){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(sol.searchMatrix(matrix, 3));
        System.out.println(sol.searchMatrix(matrix, 20));
        System.out.println(sol.searchMatrix(matrix, 23));
        System.out.println(sol.searchMatrix(matrix, -1));
        System.out.println(sol.searchMatrix(matrix, 100));
        System.out.println(sol.searchMatrix(matrix, 22));
        System.out.println(sol.searchMatrix(matrix, 8));
    }
}
