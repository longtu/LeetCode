package wr.leetcode.algo.find_minimum_in_rotated_sorted_array_ii;

public class Solution {
    public int findMin(int[] num) {
        if (null == num || num.length == 0) {
            throw new RuntimeException("Invalid Input!");
        }

        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            if (num[start] < num[end]) {
                return num[start];
            } else if(num[start] == num[end]) {
                if(start < end) {
                    start ++;
                }
            } else {
                int mid = start + ((end - start) >> 1);
                if (num[start] <= num[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (start == end) {
                break;
            }
        }
        return num[start];
    }
}
