public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0; 

        int start = 0;
        int end = height.length -1; 
        int maxArea = 0;
        while(start < end) {
            int area = 0;
            if(height[start] <= height[end]){
                area = height[start] * (end-start);
                start++;
            }else {
                area = height[end] * (end-start);
            
            }
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
