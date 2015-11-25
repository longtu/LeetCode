package wr.leetcode.algo.container_with_most_water;

public class Solution {



  public int maxArea(int[] height) {
    int ret = 0;
    if (null != height && height.length > 1) {
      int n = height.length;
      int start = 0;
      int end = n-1;
      int max = 0;
      while(start <= end ) {
        int area = Math.min(height[start], height[end]) * (end - start);
        max = Math.max(max, area);
        if(height[start] <= height[end]) {
          start ++;
        } else {
          end --;
        }
      }
      ret = max;
    }
    return ret;
  }



  /*
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
    }*/
}