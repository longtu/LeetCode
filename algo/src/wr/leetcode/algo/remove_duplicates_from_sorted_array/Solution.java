package wr.leetcode.algo.remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] A) {
        int ret = 0;
        if(null != A) {
            int start = -1;
            int end = 0;
            while(end < A.length) {
                if (start == -1 || A[end] != A[start]) {
                    A[++start] = A[end];
                }
                end++;
            }
            ret = start +1;
        }
        return ret;
    }
}
