package wr.leetcode.algo.Linkedin;

import java.util.LinkedList;
import java.util.List;

public class AddInterval {
    List<int[]> intervals = new LinkedList<>();

    /**
     * Adds an interval [from, to] into internal structure.
     */
    void addInterval(int from, int to) {
        intervals.add(new int[]{from, to});
    }

    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     * <p>
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     * <p>
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length
     * is a sum for both intervals, that is 6.
     * <p>
     * _________
     * ___
     * ____________
     * <p>
     * 0  1    2    3    4    5   6   7    8    9    10
     */
    int getTotalCoveredLength() {

        int total = 0;
        int[] curr = null;
        intervals.sort((a, b) -> (a[0] - b[0]));

        for (int[] interval : intervals) {
            if (curr == null) {
                curr = new int[]{interval[0], interval[1]};
            } else if (Math.max(curr[0], interval[0]) <= Math.min(curr[1], interval[1])) {
                curr = new int[]{Math.min(interval[0], curr[0]), Math.max(interval[1], curr[1])};
            } else {
                total += curr[1] - curr[0];
                curr = new int[]{interval[0], interval[1]};
            }
        }
        if (null != curr) {
            total += curr[1] - curr[0];
        }
        return total;
    }

    public static void main(String[] args) {
        AddInterval solution = new AddInterval();

        for (int[] i : new int[][]{
                {3,6},
                {8,9},
                {1,5},
                {2,3},
                {7,8},
                {1,9},
                {-1,0}
        }) {
            solution.addInterval(i[0], i[1]);
            System.out.println(solution.getTotalCoveredLength());
        }
    }
}
