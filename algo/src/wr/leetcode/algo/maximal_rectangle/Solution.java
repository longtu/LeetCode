package wr.leetcode.algo.maximal_rectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if ( null == matrix || 0 == matrix.length ||
                0 == matrix[0].length ) {
            return max;
        }

        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                arr[j] = (matrix[i][j] == '1')? ( 1 + arr[j] ):(0);
            }
            int area = maxRectangle(arr);
            if(area > max) {
                max = area;
            }
        }
        return max;
    }

    public int maxRectangle(int [] h){

        int[] height = new int[h.length + 2];
        for (int i = 0; i < h.length; ++i) {
            height[i + 1] = h[i];
        }

        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; ++i) {
            int hi = height[i];
            if(!st.isEmpty() && height[st.peek()] > hi ) {
                while (!st.isEmpty() && height[st.peek()] > hi) {
                    int hs = height[st.pop()];
                    int area = hs * (i - 1 - st.peek());
                    max = Math.max(area, max);
                }
            }
            st.push(i);
        }
        return max;
    }

}
