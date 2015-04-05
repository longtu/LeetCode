package wr.leetcode.algo.max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    public int maxPoints(Point[] points) {
    	int ret = 0;
    	if (null == points) {
    		return ret;
    	}
    	for (Point origin : points) {
            int line = 0;
            int max = 0;
            Map<Double, Integer> counts = new HashMap();
            for (Point point : points) {
                if(point.x == origin.x && point.y == origin.y) {
                    line ++;
                } else  {
                    int dy = point.y - origin.y;
                    int dx = point.x - origin.x;
                    Double ratio;
                    if (dx == 0) {
                        ratio = Double.POSITIVE_INFINITY;
                    } else {
                        ratio = 1.0 * dy / dx;
                    }
                    int val = counts.getOrDefault(ratio, 0) + 1;
                    max = Math.max(max, val);
                    counts.put(ratio, val);
                }
            }
            ret = Math.max(ret, max+line);
        }
    	return ret;
    }
}
