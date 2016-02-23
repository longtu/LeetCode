package wr.leetcode.algo.airbnb;

public class Rectangular {

    /**
     * determine if two rectangular overlaps
     */
    public boolean hasIntersect( int left1, int top1, int right1, int bottom1,
                          int left2, int top2, int right2, int bottom2 ) {

        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        int top = Math.min(top1, top2);
        int bottom = Math.max(bottom1, bottom2);

        return (right >= left) && (top >= bottom);
    }

    /**
     * find overlap area (if overlaps) between two rectangular
     */
    public double overlap( int left1, int top1, int right1, int bottom1,
                           int left2, int top2, int right2, int bottom2 ) {

        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        int top = Math.min(top1, top2);
        int bottom = Math.max(bottom1, bottom2);

        return Math.max(right-left, 0) * Math.max( top - bottom, 0);
    }
}
