package wr.leetcode.algo.sparse_matrix_multiplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {

        int[][] ret = new int[0][0];
        if(null != A && A.length > 0 && A[0].length > 0) {
            Map<Integer,Map<Integer, Integer>> left = sparseMatrix(A, true);
            Map<Integer,Map<Integer, Integer>> right = sparseMatrix(B, false);
            int m = A.length;
            //BUG: B[0].length instead of A[0].length
            int n = B[0].length;
            ret = new int[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int val = 0;
                    if(left.containsKey(i) && right.containsKey(j)) {
                        val = multiply(left.get(i), right.get(j));
                    }
                    ret[i][j] = val;
                }
            }
        }
        return ret;
    }

    public int multiply(Map<Integer, Integer> left, Map<Integer, Integer> right) {
        return left.keySet().stream()
                .filter(right::containsKey)
                .collect(Collectors.summingInt((a)->(left.get(a)*right.get(a))));

    }

    //IMPROVEMENTS: simplifying even further using map of maps
    public Map<Integer,Map<Integer, Integer>> sparseMatrix(int[][] matrix, boolean useRow) {

        int n = (useRow)?(matrix.length):(matrix[0].length);
        Map<Integer, Map<Integer, Integer>> ret = new HashMap<>();

        if(useRow) {
            for (int i = 0; i < n; ++i) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < matrix[i].length; ++j) {
                    if(matrix[i][j] != 0) {
                        map.put(j, matrix[i][j]);
                    }
                }
                if(!map.isEmpty()) {
                    ret.put(i, map);
                }
            }
        } else {
            for (int i = 0; i < n; ++i) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < matrix.length; ++j) {
                    if(matrix[j][i] != 0) {
                        map.put(j, matrix[j][i]);
                    }
                }
                if(!map.isEmpty()) {
                    ret.put(i, map);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] B = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int[][] ret = sol.multiply(A, B);
        for (int[] arr : ret) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
