package wr.leetcode.algo.Linkedin;

public class FourDigitSequenceCounts {

    public int totalNumbers( int[] counts ) {
        int n = 0;
        for (int c : counts) {
            n += c;
        }
        return totalNumbers(counts, -1, 0, n);
    }

    public int totalNumbers(int[] counts, int prev, int index, int n) {
        int ret = 0;
        if (index == n) {
            ret = 1;
        } else {
            for ( int c = 0; c < counts.length; ++c) {
                if ( c != prev && counts[c] > 0 ) {
                    counts[c] --;
                    ret += totalNumbers(counts, c, index+1, n);
                    counts[c] ++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FourDigitSequenceCounts sol = new FourDigitSequenceCounts();
        for (int[] test : new int[][] {
                {1,1,1,1},
                {2},
                {2,1},
                {1,2},
                {5,2,1,1},
                {5,1,1,1,1},
                {5,2,1,1,0},
                {5,1,1,1},
        }) {
            System.out.println(sol.totalNumbers(test));
        }
    }
}
