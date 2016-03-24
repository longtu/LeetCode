package wr.leetcode.algo.Facebook;

public class SegmentIntersection {

    private static class Point {
        double x;
        double y;

        public Point (double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * left:    x1, y1
     * right    x2, y2
     *
     * cross: x1y2 - x2y1
     */
    private double cross (Point left, Point right) {
        return (left.x * right.y - left.y * right.x);
    }

    private Point vectorOf(Point start, Point end) {
        return new Point( end.x - start.x, end.y - start.y);
    }

    private boolean onSegment(Point s, Point e, Point p) {
        double xMin = Math.min(s.x, e.x);
        double xMax = Math.max(s.x, e.x);
        double yMin = Math.min(s.y, e.y);
        double yMax = Math.max(s.y, e.y);
        double x = p.x;
        double y = p.y;
        return xMin <= x && x <= xMax && yMin <= y && y <= yMax;
    }

    /**
     * will not work if the two segment is and on the same line but separated
     */
    public boolean segmentIntersect(Point p1, Point p2, Point q1, Point q2) {
        Point p1p2 = vectorOf(p1, p2);
        Point p1q1 = vectorOf(p1, q1);
        Point p1q2 = vectorOf(p1, q2);

        Point q1q2 = vectorOf(q1, q2);
        Point q1p1 = vectorOf(q1, p1);
        Point q1p2 = vectorOf(q1, p2);

        double direction1 = cross(p1p2, p1q1);
        double direction2 = cross(p1p2, p1q2);
        double direction3 = cross(q1q2, q1p1);
        double direction4 = cross(q1q2, q1p2);

        boolean ret = false;

        if(direction1 * direction2 < 0 && direction3 * direction4 < 0) {
            ret = true;
        } else if (direction1 == 0 && onSegment(p1,p2, q1)) {
            ret = true;
        } else if (direction2 == 0 && onSegment(p1,p2, q2)) {
            ret = true;
        } else if (direction3 == 0 && onSegment(q1, q2, p1)) {
            ret = true;
        } else if (direction4 == 0 && onSegment(q1, q2, p2)) {
            ret = true;
        }
        return ret;
    }


    public static void main(String[] args) {
        SegmentIntersection sol = new SegmentIntersection();
        //inline
        System.out.println(sol.segmentIntersect(new Point(0,0), new Point(1,1), new Point(2,2), new Point(3,3)));
        System.out.println(sol.segmentIntersect(new Point(0,0), new Point(1,1), new Point(2,2), new Point(1,1)));
        System.out.println(sol.segmentIntersect(new Point(0,0), new Point(1,1), new Point(1,0), new Point(0,1)));
        System.out.println(sol.segmentIntersect(new Point(0,0), new Point(1,1), new Point(1,0), new Point(0.5,0.5)));
    }
}
