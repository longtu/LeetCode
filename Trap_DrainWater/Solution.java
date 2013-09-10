
public class Solution {
    public int trap(int[] A) {
        
        if(A == null || A.length <3)
            return 0;
        
        int [] leftHeight = new int [A.length];
        int [] rightHeight = new int [A.length];
        
        int length = A.length;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < A.length; ++i){
            if(i == 0){
                leftHeight[i] = leftMax;
                rightHeight[length-1-i] = rightMax;
            }else{
                leftHeight[i] = (leftMax > A[i-1])?(leftMax):(A[i-1]);
                leftMax = leftHeight[i];
                rightHeight[length-1-i] = (rightMax > A[length-i])?(rightMax):(A[length-i]);
                rightMax = rightHeight[length-1-i];
            }
        }
        int sum = 0;
        for(int i = 0; i< A.length; ++i){
            int height = (leftHeight[i] < rightHeight[i])?(leftHeight[i]):(rightHeight[i]);
            if(height <= A[i])
                continue;
            sum +=( -A[i] + height);
        }
        return sum;
    }

}
