package wr.leetcode.algo.merge_sorted_array;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int end = m + n -1;


        while( end >= 0) {
            if(m > 0 && n > 0) {
                int l = nums1[m-1];
                int r = nums2[n-1];
                if(l >= r) {
                    nums1[end] = nums1[m-1];
                    m--;
                } else {
                    nums1[end] = nums2[n-1];
                    n--;
                }
            } else if (n > 0) {
                nums1[end] = nums2[n-1];
                n--;
            } else {
                break;
            }
            end--;
        }
    }



    /*
    public void merge(int A[], int m, int B[], int n) {

        if(null == B || n == 0) {
            return;
        }

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j >= 0) {
            while(i >=0 && B[j] <= A[i]) {
                A[k--] = A[i--];
            }
            A[k--] = B[j--];
        }
    }*/
}