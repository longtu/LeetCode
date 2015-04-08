package wr.leetcode.algo.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if ( null != height) {
            int start = 0;
            int end = height.length - 1;
            while(start < end) {
               int min;
               int dist = end - start;
               if(height[start] <= height[end]){
                    min = height[start];
                    start++;
               } else {
                    min = height[end];
                    end--;
               }
               maxArea = Math.max(maxArea, min*dist);
            }
        }
        return maxArea;
    }
}