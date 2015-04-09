package wr.leetcode.algo.merge_sorted_array;

public class Solution {
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
    }
}