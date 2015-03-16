public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if(A == null || B == null) {
    		return 0;
    	}
    	int totalElements = A.length + B.length;
    	if(totalElements == 0)
    		return 0;
    	if((totalElements)%2 == 1){
    		return findKthMaxofSortedArrays(A,B,totalElements/2+1);
    	}
    	double a = findKthMaxofSortedArrays(A,B,totalElements/2);
    	double b = findKthMaxofSortedArrays(A,B,totalElements/2+1);
    	return (a+b)/2;
    }
    private int findKthMaxofSortedArrays(int A[], int B[], int k){
        if(A.length + B.length < k)
            return  -1;
        return findKthMaxofSortedArrays(A,0, A.length-1, B, 0, B.length-1,k);
    }

    // k is from 1....
    private int findKthMaxofSortedArrays(int A[], int startA, int endA,
            int B[], int startB, int endB, int k){
        //if there is only one array left
        if(startA > endA)
            return B[k+startB-1];
        if(startB > endB)
            return A[k+startA-1];

        int i = startA + ((endA-startA)>>1);
        int j = startB + ((endB-startB)>>1);

        // t is the total number of elements including 
        // A[0], A[1]..., A[i-1] 
        // B[0], B[1]..., B[j-1]
        // and min(A[i], B[j])
        int t = i+j-startA-startB +1;

        //find the min
        if(A[i] >= B[j]){
            // A1, A[i], A2
            // B1, B[j], B2
            // if(A[i] >= B[j])
            // there is no way to determine relationship  between A1 and B2 
            // only A2 and B1 can be discarded when we do recursion
        	if(t >= k)
        		return findKthMaxofSortedArrays(A,startA,i-1,B,startB,endB,k);
        	else
        		return findKthMaxofSortedArrays(A,startA,endA,B,j+1,endB,k-(j-startB)-1);
        }else {
        	if(t >= k)
        		return findKthMaxofSortedArrays(A,startA,endA,B,startB,j-1,k);
        	else
        		return findKthMaxofSortedArrays(A,i+1,endA,B,startB,endB,k-(i-startA)-1);
        }
        // it is impossible to determin
    }
}
