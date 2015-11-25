package wr.leetcode.algo;

public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        if(null != ratings && 0 != ratings.length) {
            int n = ratings.length;
            int [] left = new int[n];
            int [] right = new int[n];
            for (int i = 0; i < n; ++i) {
                int val;
                if(i == 0 || ratings[i] <= ratings[i-1] ) {
                    val = 1;
                } else {
                    val = left[i-1] + 1;
                }
                ratings[i] = val;
            }
            for (int i = n -1 ; i >=0; --i) {
                int val;
                if (i == n-1 || ratings[i] <= ratings[i+1]) {
                    val = 1;
                } else {
                    val = right[i+1] + 1;
                }
                ratings[i] = val;
            }
            for (int i = 0; i <n; ++i) {
                sum += Math.max(left[i], right[i]);
            }
        }
        return sum;
    }
}
