public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0)
            return 1;
        //move negative or 0 to the back
        int start = 0;
        for(int end = A.length-1; start<end;){
            if(A[start] <= 0){
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
                end--;
            }else{
                start++;
            }
        }
        //(start+1) is number of positive integers
        if(A[start] <=0)
            start--;
        //set all integers back to their indexed position
        for(int i = 0; i<start+1; ++i){
            while(A[i] != i+1){
                if(A[i] > start+1 )
                    break;
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp; 
            }
        }
        //O(N) scan again
        for(int j = 0; j<start+1; ++j)
            if(A[j] != j+1)
                return j+1;
        return start+2;
    }

}
