package wr.leetcode.algo.Linkedin;


public class SortedArrayMinDist {

    //neither left/right is empty nor null
    public int minDist(int[] left, int[] right) {

        int leftLen = left.length;
        int rightLen = right.length;
        int minDist = Integer.MAX_VALUE;

        boolean finish = false;
        int l = 0;
        int r = 0;
        while (!finish) {
            int lv = left[l];
            int rv = right[r];
            int dist = Math.abs(lv-rv);
            minDist = Math.min(minDist, dist);

            if (lv == rv) {
                finish = true;
            } else if (lv < rv) {
                if (l == leftLen - 1) {
                    finish = true;
                } else {
                    l++;
                }
            } else {
                if (r == rightLen-1) {
                    finish = true;
                } else {
                    r++;
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        SortedArrayMinDist solution = new SortedArrayMinDist();

        for (int[][] arr : new int[][][] {
                { {10,30,50,70,}, {1,14,16,280} },
                { {1,3,6,7}, {2,4,6,8} },
                { {1,7,13}, {4,9, 12} }
        }) {
            System.out.println(solution.minDist(arr[0], arr[1]));
        }

    }
}

