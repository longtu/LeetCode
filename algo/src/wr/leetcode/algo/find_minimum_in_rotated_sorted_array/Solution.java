package wr.leetcode.algo.find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] num) {
        if(null == num || num.length == 0) {
            throw new RuntimeException("Invalid Input!");
        }

        int start = 0;
        int end = num.length - 1;

        while(start <= end) {
            if(num[start] <= num[end]) {
                return num[start];
            } else {
                int mid = start +((end-start)>>1);
                if(num[start] <= num[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if(start  == end) {
                break;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {4,5,6,7,0,1,2};
        int[] b = {1,2,3,4,5,6,7};
        int[] c = {2,3,4,5,6,7,1};
        int[] d = {1};
        System.out.println(sol.findMin(arr));
        System.out.println(sol.findMin(b));
        System.out.println(sol.findMin(c));
        System.out.println(sol.findMin(d));

    }
}
