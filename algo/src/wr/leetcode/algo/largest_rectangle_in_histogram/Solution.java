package wr.leetcode.algo.largest_rectangle_in_histogram;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] h) {
        if(null == h) {
            h = new int[0];
        }
        int[] height = new int[h.length +2];
        System.arraycopy(h, 0, height, 1, h.length );
        height = Arrays.copyOf(height, height.length + 1);
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            if(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int j = 0;
                while(!stack.isEmpty() && height[stack.peek()] > height[i]){
                    j = stack.pop();
                    maxArea = Math.max(maxArea, (i-j)*height[j]);

                }
                maxArea = Math.max(maxArea, (i-j+1)*height[i]);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
