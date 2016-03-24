package wr.leetcode.algo.Facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OverlapRectangular {

    private static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return String.format("[%s,%s]", x, y);
        }
    }

    private static class Rectangular{
        Point topLeft;
        Point bottomRight;

        public Rectangular(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public Rectangular(int a, int b, int c, int d) {
            this(new Point(a,b), new Point(c,d));
        }
        @Override
        public String toString() {
            return String.format("{%s,%s}", topLeft, bottomRight);
        }
    }

    int[] toArray(Set<Integer> set) {
        int[] ret = new int[set.size()];
        int i = 0;
        for (int k : set){
            ret[i++] = k;
        }
        Arrays.sort(ret);
        return ret;
    }

    int indexOf (int[] arr, int key) {
        return Arrays.binarySearch(arr, key);
    }

    public Rectangular mostOverlapArea( Rectangular[] recs ) {
        Set<Integer> xPos = new HashSet<>();
        Set<Integer> yPos = new HashSet<>();
        for (Rectangular rec : recs) {
            Point tl = rec.topLeft;
            Point br = rec.bottomRight;
            xPos.add(tl.x);
            xPos.add(br.x);
            yPos.add(tl.y);
            yPos.add(br.y);
        }

        int xs [] = toArray(xPos);
        int ys [] = toArray(yPos);
        int [][] counts = new int[xs.length][ys.length];

        int max = 0;
        int mX =  0;
        int mY =  0;

        for ( Rectangular rec : recs ) {
            int minX = indexOf(xs, rec.topLeft.x);
            int maxY = indexOf(ys, rec.topLeft.y);
            int maxX = indexOf(xs, rec.bottomRight.x);
            int minY = indexOf(ys, rec.bottomRight.y);

            for (int i = minX+1; i <= maxX; ++i) {
                for (int j = minY+1; j <= maxY; ++j ) {
                    int val = counts[i][j] + 1;
                    counts[i][j] = val;
                    if(val > max) {
                        max = val;
                        mX = i;
                        mY = j;
                    }
                }
            }
        }

        Rectangular ret = null;
        if (max > 0) {
            ret = new Rectangular(
                    new Point(xs[mX-1], ys[mY]),
                    new Point(xs[mX], ys[mY-1])
            );
        }
        return ret;
    }

    public int overlapArea( Rectangular[] recs ) {
        Set<Integer> xPos = new HashSet<>();
        Set<Integer> yPos = new HashSet<>();
        for (Rectangular rec : recs) {
            Point tl = rec.topLeft;
            Point br = rec.bottomRight;
            xPos.add(tl.x);
            xPos.add(br.x);
            yPos.add(tl.y);
            yPos.add(br.y);
        }

        int xs [] = toArray(xPos);
        int ys [] = toArray(yPos);
        boolean [][] counts = new boolean[xs.length][ys.length];


        int area =  0;
        for ( Rectangular rec : recs ) {
            int minX = indexOf(xs, rec.topLeft.x);
            int maxY = indexOf(ys, rec.topLeft.y);
            int maxX = indexOf(xs, rec.bottomRight.x);
            int minY = indexOf(ys, rec.bottomRight.y);

            for (int i = minX+1; i <= maxX; ++i) {
                for (int j = minY+1; j <= maxY; ++j ) {
                    if(!counts[i][j]) {
                        counts[i][j] = true;
                        area += (xs[i] - xs[i-1]) * (ys[j]-ys[j-1]);
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        OverlapRectangular sol = new OverlapRectangular();

        Rectangular [] input = new Rectangular[] {
                new Rectangular(-1,3,2,0),
                new Rectangular(-1,3,1,1),
                new Rectangular(0,2,2,0),
                new Rectangular(1,1,3,-4),
                new Rectangular(99,100, 100, 99),
                new Rectangular(99,100, 100, 99),
                new Rectangular(99,100, 100, 99),
                new Rectangular(99,100, 100, 99),
                new Rectangular(99,100, 100, 99),
        };

        for (int i = 1; i <= input.length; ++i) {
            Rectangular[] recs = Arrays.copyOfRange(input, 0, i);
            System.out.println(sol.mostOverlapArea(recs));
            System.out.println(sol.overlapArea(recs));
            System.out.println();
        }


    }

}
