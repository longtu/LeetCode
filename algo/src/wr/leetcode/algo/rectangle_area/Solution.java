package wr.leetcode.algo.rectangle_area;

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        long union = (C-A)*(D-B) + (G-E)*(H-F);

        //overflow to be the right place!!!
        long diffX = (A <= E) ? ((long)C-E):((long)G-A);
        diffX = (diffX < 0) ? (0):(diffX);

        long diffY = (B <= F) ? ((long)D-F):((long)H-B);
        diffY = (diffY < 0)? (0):(diffY);

        return (int) (union - (diffX*diffY));
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
        System.out.println(sol.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }



    /*
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

    */
}
