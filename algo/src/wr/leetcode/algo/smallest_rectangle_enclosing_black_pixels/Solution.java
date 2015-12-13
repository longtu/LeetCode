package wr.leetcode.algo.smallest_rectangle_enclosing_black_pixels;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int area = 0;
        if( null != image && image.length > 0 && image[0].length > 0) {
            int [] dy = {0, -1, 1, 0};
            int [] dx = {-1, 0, 0, +1};

            int h = image.length;
            int w = image[0].length;

            int maxX = x;
            int maxY = y;
            int minX = x;
            int minY = y;

            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point (x, y));
            Set<Integer> visited = new HashSet<>();

            while(!queue.isEmpty()) {
                Point v = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    int nx = dx[i] + v.x;
                    int ny = dy[i] + v.y;
                    if(nx > -1 && nx < h && ny > -1 && ny < w && '1' == image[nx][ny] &&
                            !visited.contains(w * nx + ny)) {
                        queue.add(new Point(nx, ny));
                        visited.add( w * nx + ny);
                        maxX = Math.max(nx, maxX);
                        maxY = Math.max(ny, maxY);
                        minX = Math.min(nx, minX);
                        minY = Math.min(ny, minY);
                    }
                }
            }
            area = (maxX - minX + 1) * (maxY - minY + 1);
        }
        return area;
    }

    class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] arr = {
            {'0','0','1','0'},
            {'0','1','1','0'},
            {'0','1','0','0'}
        };
        System.out.println(sol.minArea(arr, 0, 2));
    }
}
