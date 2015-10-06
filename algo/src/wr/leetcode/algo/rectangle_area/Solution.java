package wr.leetcode.algo.rectangle_area;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C-A) * (D-B) + (G-E)* (H-F);

        int x = Math.min(C,G);
        int y = Math.max(A,E);

        int z = Math.min(D, H);
        int w = Math.max(B,F);

        //formula!!!
        //overflow!!!
        int overLap = ((x>y)?(x-y):(0))*((z>w)?(z-w):(0));
        return sum - overLap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
