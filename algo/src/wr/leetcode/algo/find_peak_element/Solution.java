package wr.leetcode.algo.find_peak_element;

public class Solution {
    public int findPeakElement(int[] num) {
        if(null == num || 0 == num.length) {
            throw new RuntimeException("Invalid Input");
        }

        int start = 0;
        int end = num.length-1;

        int ret = 0;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            int left = compare(num, mid-1, mid);
            int right = compare(num, mid, mid+1);

            if(left == 0 || right == 0) {
                throw new RuntimeException("Invalid Input");
            }

            if( left< 0 && right>0) {
                ret = mid;
                break;
            } else if(left < 0 && right < 0) {
                start = mid + 1;
            } else if(left > 0 && right > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }

    public int compare(int[]num, int left, int right){

        if (left > right){
            return -1*compare(num, right, left);
        }
        if(left == -1) {
            return -1;
        }
        if(right == num.length) {
            return 1;
        }
        return num[left] - num[right];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,1};
        System.out.println(sol.findPeakElement(arr));
    }
}
