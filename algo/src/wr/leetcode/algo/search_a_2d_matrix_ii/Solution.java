package wr.leetcode.algo.search_a_2d_matrix_ii;

public class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ret = false;
        if( null != matrix && 0 < matrix.length && 0 < matrix[0].length) {
            for ( int i = 0; i < matrix.length; ++i) {
                if( matrix[i][0] > target) {
                    break;
                } else if (binarySearch(matrix[i], target)) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    public boolean binarySearch(int[] nums, int target) {
        boolean found = false;
        int start = 0;
        int end = nums.length - 1;

        while( start <= end ) {
            int mid = start + ( (end - start) >>1);
            int mv = nums[mid];
            if (mv == target) {
                found = true;
                break;
            } else if (mv > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return found;
    }








/*
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ret = false;
        if(null != matrix && matrix.length > 0 && matrix[0].length > 0) {
            int cols = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; ++i) {
                int index = searchSmaller(matrix[i], cols, target);
                if (index == -1) {
                    ret = false;
                    break;
                }
                if(matrix[i][index] == target) {
                    ret = true;
                    break;
                }
                cols = index;
            }
        }
        return ret;
    }

    public int searchSmaller( int [] arr, int tail, int key ) {

        int start = 0;
        int end = tail;
        int found = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            int val = arr[mid];
            if( val == key) {
                found = mid;
                break;
            } else if ( val > key) {
                end = mid -1;
            } else {
                start = mid + 1;
                found = mid;
            }
        }
        return found;
    }
*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][][] arrs ={
                {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}},
                {{5}},
                null,
                {{-5}}
        };

        for (int[][] arr : arrs) {
            System.out.println(sol.searchMatrix(arr, 5));
            System.out.println(sol.searchMatrix(arr, 20));
            System.out.println(sol.searchMatrix(arr, -10));
        }
    }

}
