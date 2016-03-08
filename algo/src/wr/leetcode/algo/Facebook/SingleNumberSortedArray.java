package wr.leetcode.algo.Facebook;

public class SingleNumberSortedArray {

    /**
     * Consider to maintain the 2N + 1 sub-array
     */
    public static int findSingle(int[] numbers) {
        // n >=1 and n is odd number
        int n = numbers.length;
        int s = 0;
        int e = n - 1;
        int find = -1;
        while( s<=e ) {
            if (s == e) {
                find = numbers[s];
                s++;
            } else { // e-s >=2
                int mid = s + ((e-s)>>1);
                int mv = numbers[mid];
                int sv = numbers[mid-1];
                int ev = numbers[mid+1];
                if (sv == mv ) {
                    if((mid+1)%2 == 0) {
                        s = mid + 1;
                    } else {
                        e = mid - 2;
                    }
                } else if (mv == ev){
                    if((mid+1)%2 == 1) {
                        s  = mid + 2;
                    } else {
                        e = mid -1;
                    }
                } else {
                    find = mv;
                    break;
                }
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1},
                {1,2,2},
                {1,1,2},
                {1,2,2,4,4},
                {1,1,2,4,4},
                {1,1,2,2,4},
                {1,2,2,4,4,5,5},
                {1,1,2,4,4,5,5},
                {1,1,2,2,4,5,5},
                {1,1,2,2,4,4,5}
        };

        for (int[] a : arr) {
            System.out.println(findSingle(a));
        }
    }
}
