package wr.leetcode.algo.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int numIslands(char[][] grid) {

        int ret = 0;

        if( null != grid && grid.length > 0 && grid[0].length > 0) {
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if('1' == grid[i][j] ) {
                        ret ++;
                        explore(grid, new Pos(i, j));
                    }
                }
            }
        }

        return ret;
    }

    public void explore(char[][] grid, Pos pos) {
        int m = grid.length;
        int n = grid[0].length;
        int [] xd = {0, -1, 1, 0};
        int [] yd = {-1, 0, 0, 1};
        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        grid[pos.x][pos.y] = 'V';


        while(!q.isEmpty()) {
            Pos p = q.remove();
            for (int i = 0; i < 4; ++i) {
                int dx = xd[i] + p.x;
                int dy = yd[i] + p.y;
                if(dx >=0 && dy >=0 && dx < m && dy < n && grid[dx][dy] == '1') {
                    grid[p.x][p.y] = 'V';
                    q.add(new Pos(dx, dy));
                }
            }
        }
    }

    class Pos{
        public int x;
        public int y;
        public Pos(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }

    /*
    public int numIslands(char[][] grid) {
        int ret = 0;
        if(null == grid || 0 == grid.length || 0 == grid[0].length) {
            return ret;
        }

        for(int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j) {
                if('1' == grid[i][j]) {
                    exploreIsland(i,j,grid);
                    ret += 1;
                }
            }
        }
        return ret;
    }

    public void exploreIsland(int x, int y, char[][]grid){

        Queue<Pos> queue = new LinkedList();
        queue.add(new Pos(x,y));
        grid[x][y] = '0';
        while(!queue.isEmpty()) {
            Pos node = queue.poll();
            int i = node.i;
            int j = node.j;
            if(i > 0 && grid[i-1][j] == '1') {
                grid[i-1][j] = '0';
                queue.offer(new Pos(i-1,j));
            }
            if(j > 0 && grid[i][j-1] == '1') {
                grid[i][j-1] = '0';
                queue.offer(new Pos(i,j-1));
            }

            if(i < grid.length-1 && grid[i+1][j] == '1') {
                grid[i+1][j] = '0';
                queue.offer(new Pos(i+1,j));
            }

            if(j < grid[0].length-1 && grid[i][j+1] == '1') {
                grid[i][j+1] = '0';
                queue.offer(new Pos(i,j+1));
            }
        }
    }*/
}