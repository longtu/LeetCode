package wr.leetcode.algo.Linkedin;

public class MaxProductSubsequence {

    public int maxProductSubsequence(int[] values) {
        int ret = 0;
        values = (null == values)?(new int[0]):(values);
        int n = values.length;

        if (n > 0) {
            int[] max = new int[n];
            int[] min = new int[n];
            for (int i = 0; i < n; ++i) {
                int val = values[i];
                if ( 0 == i) {
                    max[i] = val;
                    min[i] = val;
                } else {
                    max[i] = Math.max(max[i-1],
                            Math.max(max[i-1]*val, min[i-1]*val));
                    max[i] = Math.max(max[i], val);

                    min[i] = Math.min(min[i - 1],
                            Math.min(max[i - 1] * val, min[i - 1] * val));
                    min[i] = Math.min(min[i], val);
                }
            }
            ret = max[n-1];
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxProductSubsequence solution = new MaxProductSubsequence();

        for (int[] arr : new int[][] {
                {-1,2},
                {-2,2},
                {2,2,-2},
                {-2,2,-2},

                {-2,-3,4},
                {0,2,5,0},
                {0,2,-5,0},
                {-2,0,-5,0},
                {-2,0},
                {-2,0,5},
                {}
        }) {

            System.out.println(solution.maxProductSubsequence(arr));
        }
    }
}