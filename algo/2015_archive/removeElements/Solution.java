public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0 )
           return 0; 

        int start = 0;
        int end = A.length - 1;

        while(start <=end) {
            if(A[start] == elem){
                A[start] = A[end--];
                continue;
            }
            start ++;
        }
        return start;
    }
}
