package wr.leetcode.algo.longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {



    public int lengthOfLIS00(int[] nums) {
        if (nums.length==0) return 0;
        int len = nums.length;
        int[] seqEnd = new int[len+1];
        seqEnd[1] = 0;
        int lisLen = 1;
        for (int i=1;i<len;i++){
            int pos = findPos(nums,seqEnd,lisLen,i);
            seqEnd[pos] = i;
            if (pos>lisLen) lisLen = pos;

        }

        return lisLen;

    }

    public int findPos(int[] nums, int[] seqEnd, int lisLen, int index){
        int start = 1;
        int end = lisLen;

        while (start<=end){
            int mid = (start+end)/2;

            if (nums[index] == nums[seqEnd[mid]]){
                return mid;
            } else if (nums[index]>nums[seqEnd[mid]]){
                start = mid+1;
            } else end = mid-1;
        }
        return start;
    }


    public int lengthOfLIS(int[] nums) {

        int ret = 0;
        if( null != nums && nums.length > 0) {
            int n = nums.length;
            int[] m = new int[n+1];
            m[1] = 0;
            ret = 1;

            for (int i = 1; i < n; ++i) {
                int start = 1;
                int end = ret;
                int val = nums[i];


                int found = 1;
                while(start <= end) {
                    int mid = (start + end)/2;
                    int midV = nums[m[mid]];
                    if( midV == val) {
                        found = mid;
                        break;
                    } else if(midV < val) {
                        start = mid + 1;
                        found = start;
                    } else if(midV > val){
                        end = mid-1;
                    }
                }

                //found is length of subsequence smaller than current value;
                m[found] = i;
                if(found > ret) {
                    ret = found;
                }
            }
        }
        return ret;
    }


    //Sorted + lcs
    public int lengthOfLIS1(int[] nums) {
        int ret = 0;

        if( null != nums ) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            //BUG: duplicates will need to removed
            ret= lcs(sorted, nums);
        }
        return ret;
    }
    public int lcs(int[] left, int[] right) {

        int m = left.length;
        int n = right.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <=m; ++i) {
            for (int j = 0; j <=n; ++j) {
                int val;
                //BUG: i, j instead of using m, n
                if(0 == i || 0 == j) {
                    val = 0;
                    //BUG: i-1, j-1 instead of i, j
                    //dp[i-1, j] dp[i,j-1]
                } else if( left[i-1] == right[j-1] ){
                    val = dp[i-1][j-1] + 1;
                    val = Math.max(dp[i][j-1],val);
                    val = Math.max(dp[i-1][j],val);

                } else {
                    //BUG: recursive relationship
                    //dp[i-1, j] dp[i,j-1]
                    val = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                dp[i][j] = val;
            }
        }
        return dp[m][n];
    }


    //2D DP solution: NLOG(N)
    public int lengthOfLIS0(int[] nums) {
        int ret = 0;
        if ( nums != null && nums.length > 0 ) {
            int n = nums.length;
            int[] glo = new int[n];
            int[] loc = new int[n];
            for (int i = 0; i < n; ++i) {
                int m = 0;
                for (int j = i-1; j >= 0; j--) {
                    //BUG: should be loc[j] > m instead of glo[j] > m
                    if(loc[j] > m && nums[j] < nums[i]) {
                        m = loc[j];
                    }
                }
                loc[i] = m + 1;
                glo[i] = Math.max(loc[i], (i>0)?(glo[i-1]):(0));
            }
            ret = glo[n-1];
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr = {
                {1,2,3,8},
                {10, 9, 2, 5, 3, 7, 101, 18},
                {1,3,6,7,9,4,10,5,6}
        };

        for (int[] a : arr) {
            System.out.println("----");
            System.out.println(sol.lengthOfLIS00(a));
            System.out.println(sol.lengthOfLIS(a));
        }
    }
}
