package wr.leetcode.algo.maximum_product_subarray;

public class Solution {

    /*
    public int maxProduct(int[] A) {

        if(A == null || A.length == 0) {
            return 0;
        }

        int [] global = new int[2];
        int [] lmax = new int[2];
        int [] lmin = new int[2];

        global[0] = A[0];
        lmax[0] = A[0];
        lmin[0] = A[0];

        for ( int i = 1; i < A.length; ++i) {
            lmin[i%2] = Math.min(A[i], Math.min( lmin[(i-1)%2]*A[i], lmax[(i-1)%2]*A[i] ));
            lmax[i%2] = Math.max(A[i], Math.max( lmin[(i-1)%2]*A[i], lmax[(i-1)%2]*A[i] ));
            global[i%2] = Math.max(global[(i-1)%2], lmax[i%2]);
        }

        return global[(A.length-1)%2];
    }

    public int maxProduct(int[] nums) {

        int ret = 0;
        if(null != nums && nums.length > 0) {
            int m = nums.length;
            int[] locMax = new int[3];
            int[] locMin = new int[3];
            int[] glo = new int[3];
            for (int i = 0; i < m; ++i) {
                locMax[i%3] = (i > 0)? ( Math.max(nums[i], Math.max(nums[i] * locMin[(i-1)%3], nums[i] * locMax[(i-1)%3])) ) : (nums[i]);
                locMin[i%3] = (i > 0)? ( Math.min(nums[i], Math.min(nums[i] * locMin[(i-1)%3], nums[i] * locMax[(i-1)%3])) ) : (nums[i]);
                glo[i%3] = (i > 0)? ( Math.max(locMax[i%3], glo[(i-1)%3])) : (locMax[i%3]);
            }
            ret = glo[(m-1)%3];
        }
        return ret;
    }*/

    public int maxProduct(int[] nums) {

        int ret = 0;
        if (null != nums && nums.length > 0) {
            int n = nums.length;
            int [] max = new int[n+1];
            int [] min = new int[n+1];
            int [] glo = new int[n+1];

            for (int i = 0; i <= n; ++i) {
                if (i == 0) {
                    max[i] = 1;
                    min[i] = 1;
                    glo[i] = 1;
                } else {
                    int self = nums[i-1];
                    int maxSelf = max[i-1] * self;
                    int minSelf = min[i-1] * self;

                    max[i] = max(self, maxSelf, minSelf);
                    min[i] = min(self, maxSelf, minSelf);
                    glo[i] = Math.max( ((i>1)?(glo[i-1]):(Integer.MIN_VALUE)), max[i]);
                }
            }
            ret = glo[n];
        }
        return ret;
    }

    int max( int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    int min( int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr= {2,3,-2,4};
        int[] arr0= {-2};

        System.out.println(sol.maxProduct(arr));
        System.out.println(sol.maxProduct(arr0));
    }

}
