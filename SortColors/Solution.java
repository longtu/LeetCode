public class Solution {
    public void sortColors(int[] A) {
        if(A == null)
            return;

        int endZero = -1;
        int start = 0;
        int end = A.length-1;


        //equal here is importatnt for start == 0
        //the 2 branch will actually cause this 
        //need real manual test!!!!!
        while(start<=end){
            if( A[start] == 1){
                start++;
            }else if(A[start] == 2){
                int tmp = A[end];
                A[end--] = A[start];
                A[start] = tmp;
            }else{
                int tmp = A[++endZero];
                A[endZero] = A[start];
                A[start++] = tmp;
            }
        }
    }
}
