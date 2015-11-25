package wr.leetcode.algo.remove_element;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if( null == nums ) {
            nums = new int[0];
        }
        int end = nums.length;
        int start = 0;

        while( start < end ) {
            if( nums[start] == val) {
                int tmp = nums[start];
                nums[start] = nums[--end];
                nums[end] = tmp;
            } else {
                start ++;
            }
        }
        return end;
    }

    /*
    public int removeElement(int[] A, int elem) {
        int ret = 0;
        if(null != A ) {
            int start = 0;
            int end = A.length-1;
            while(start <= end) {
                if (start == end) {
                    ret = 1+((elem == A[start])?(start-1):(start));
                    break;
                } else if(A[start] == elem) {
                    int tmp = A[start];
                    A[start] = A[end];
                    A[end--] = tmp;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }*/
}