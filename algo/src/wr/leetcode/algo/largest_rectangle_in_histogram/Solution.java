package wr.leetcode.algo.largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] h) {
        if(null == h) {
            h = new int[0];
        }
        int[] height = new int[h.length +2];
        System.arraycopy(h, 0, height, 1, h.length );
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            if(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int j = 0;
                while(!stack.isEmpty() ){
                    j = stack.peek();
                    maxArea = Math.max(maxArea, (i-j)*height[j]);
                    if(height[j] <= height[i]){
                        break;
                    }
                    stack.pop();
                }
                maxArea = Math.max(maxArea, (i-j+1)*height[i]);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        int[] b = {2,1,2};
        int[] c = {2,1,2};

        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(a));
        System.out.println(sol.largestRectangleArea(b));
    }
}
