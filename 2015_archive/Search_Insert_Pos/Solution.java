public class Solution {
	
	/**constraint: 1) Has to be sorted, 2) Array ***/
	/**
	 * V1:
	 * Exact search
	 */
	public int binarySearch1(int[] A, int target) {

		//Left close, right close
		int start = 0;
		int end = A.length-1;

		//both closed
		while(start <= end){
			// start+end can cause overflow
			// >>1 is much more efficient
			// () makes sure >> executed before +
			int mid = start +((end-start)>>1);
			if(A[mid]< target)
				start = mid+1;
			////////right is not close, therefore no +1 !!!!!
			else if (A[mid] > target)
				end = mid-1;
			//put not equal in the front as mostly it's not equal
			else
				return mid;
		}
		return -1;
	}
	/**
	 * V2.1: multiple instances match
	 * Search FIRST element that equals to target, if not found, return -1
	 */
	public int binarySearch2(int[] A, int target) {

		int start = 0;
		int end = A.length-1;
		int find = -1;

		while(start <= end){
			int mid = start +((end-start)>>1);
			if(A[mid] > target)
				end = mid-1;
			else if(A[mid] < target)
				start = mid+1;
			else {
				find = mid;
				end = mid-1;
			}
		}
		return find;
	}
	/**
	 * V2.2: multiple instances match
	 * Search LAST element that equals to target, if not found, return -1
	 */
	public int binarySearch3(int[] A, int target) {

		int start = 0;
		int end = A.length-1;
		int find = -1;

		while(start <= end){
			int mid = start +((end-start)>>1);
			if(A[mid] > target)
				end = mid-1;
			else if(A[mid] < target)
				start = mid+1;
			else {
				find = mid;
				start = mid+1;
			}
		}
		return find;
	}

    // first greater or equal
    public int binarySearch1(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int find = -1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                find = mid;
                end = mid - 1;
            }
        }
        return find;
    }

    // last smaller or equal
    public int binarySearch2(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int find = -1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                find = mid;
                start = mid + 1;
            }
        }
        return find;
    }

    // first greater
    public int binarySearch3(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int find = -1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                find = mid;
                end = mid - 1;
            }
        }
        return find;
    }

    // last smaller
    public int binarySearch4(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int find = -1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                find = mid;
                start = mid + 1;
            }
        }
        return find;
    }


    /** Find any Range in 	sorted array with O(logn)
     ** 					unsorted array with O(nlogn)
     */


    /** V4 k step rotated sorted Array, no duplicates
    */
    public int binarySearch6(int[] A, int target) {
        int find = -1;
        if(A == null)
            return find;
        int start = 0;
        int end = A.length-1;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(A[mid] == target)
                return mid;
            if(A[start] <= A[mid]){
                if(target >=A[start] && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else{
                if(target > A[mid] && target <=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            } 
        }
        return find;        
    }

    /** V4 k step rotated sorted Array, with duplicates
    */
    public int binarySearch6(int[] A, int target) {
        int find = -1;
        if(A == null)
            return find;
        int start = 0;
        int end = A.length-1;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(A[mid] == target)
                return mid;
            if(A[start] < A[mid]){
                if(target >=A[start] && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else if(A[start] > A[mid]){
                if(target > A[mid] && target <=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            } else start++;
        }
        return find;        
    }

	
	/** find the Kth smallest element in rotated array */
	/** assume input has no duplicates **/
	int findMin(int [] A){
		if(A == null)
			return -1;
		int start = 0;
		int end = A.length-1;
		//no solution
		if(start < end)
			return -1;
		while(start<end){
			int mid = start + ((end-start)>>2);
			if(A[mid] > A[end]){
				start = mid +1;
			}else{
				end = mid;
			}
		}
		return start;
	}
	int findKthElement(int [] A, int k ){
		if(A == null || k > A.length)
			return -1;
		int base = findMin(A);
		int index = (base +k -1)%(A.length);
		return index;
	}
	/**
	 * find Kth element in union of two sorted Array
	 *
	 *1) Two pointer O(k) solution
	 *2) O(log M + log N)
	 *
	 *
	 * NOT FINISHED YET!!!!!!
	 */
	int findKthMaxNumOfArrays(int []A, int startA, int []B, int startB, int k)
	{
	        if(A.length == startA)return B[k-1];
	        if(B.length == startB)return A[k-1];
	        int i = (startA + A.length)>>1, j = (startB+B.length)>>1;
	        
	        int [] bigger; int [] smaller;
	        int biggerIndex; int smallerIndex;
	        if(A[i] <= B[j]){
	        	smaller = A;
	        	bigger = B;
	        	biggerIndex = j;
	        	smallerIndex = i;
	        }
	        else{
	        	smaller = B;
	        	bigger = A;
	        	biggerIndex = i;
	        	smallerIndex = j;

	        }
	        int t = i + j + 1;
	        if(t >= k)return findKthMaxNumOfArrays(smaller, a, bigger, j, k);
	        else if(t < k)return findKthMaxNumOfArrays(smaller, m-i-1, bigger,b, k-i-1);
	}
	
	
	
	public static void main(String[] args){

		int A[][] = {
				{1,1,1,1,3,5,6,6,6},
				{1,1,1,3,3,3,3,3,5,5,6},
				{1,3,5,6}
		};
		int B[] = {1,3,5,6};
		int C[] = {1,3,4,5,6};

		int test [] = {-1,1,3,5,6,7};
		
		for(int i = 0; i<3; ++i){
			for(int t : test){
				System.out.println(new Solution().binarySearch5(A[i], t));
			}
			System.out.println("----");
		}
	}
}
