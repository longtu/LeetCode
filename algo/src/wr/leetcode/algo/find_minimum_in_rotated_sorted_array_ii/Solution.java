package wr.leetcode.algo.find_minimum_in_rotated_sorted_array_ii;

public class Solution {
    /*
    public int findMin(int[] nums) {

        if(null == nums || 0 == nums.length) {
            throw new IllegalStateException("Invalid state!");
        }

        int start = 0;
        int end = nums.length - 1;
        int found = -1;

        while(start <= end){
            int sv = nums[start];
            int ev = nums[end];
            if( start == end  || sv < ev ) {
                found = sv;
                break;
            } else if ( sv == ev ) {
                start ++;
            } else  { //sv > ev
                int mid = start + ((end - start) >> 1);
                int mv = nums[mid];
                if( mv >= sv) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return found;
    }

    public int findMin(int[] num) {
        if (null == num || num.length == 0) {
            throw new RuntimeException("Invalid Input!");
        }

        int start = 0;
        int end = num.length - 1;
        int ret = start;
        while (start <= end) {
            if (num[start] < num[end] || start == end) {
                ret = start;
                break;
            } else if(num[start] == num[end]) {
                start ++;
            } else { //A[start] > A[end]
                int mid = start + ((end - start) >> 1);
                if (num[start] <= num[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return num[ret];
    }*/

    public int findMin(int[] nums) {
        if(null == nums) {
            nums = new int[0];
        }
        int s = 0;
        int e = nums.length-1;
        int ret = -1;
        while(s <= e) {
            int sv = nums[s];
            int ev = nums[e];
            if(s == e || sv < ev) {
                ret = s;
            } else if (sv == ev) { // s!=e && sv == ev
                s ++;
            } else { // s!= e && sv > ev
                int m = s + ((e-s)>>1);
                int mv = nums[m];
                if( sv <= mv ) {
                    s = m + 1;
                } else if (sv > mv) {
                    e = m;
                }
            }
        }
        return nums[ret];
    }

}
