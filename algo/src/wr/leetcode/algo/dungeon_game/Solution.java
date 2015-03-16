package wr.leetcode.algo.dungeon_game;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {

        if(dungeon == null || dungeon.length == 0){
            return 1;
        }

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] life = new int [rows][cols];

        life[rows-1][cols-1] = Math.max( 1 - dungeon[rows-1][cols-1], 1);

        for(int j = rows-2; j >=0; j--) {
            life[j][cols-1] = Math.max(life[j+1][cols-1] - dungeon[j][cols-1], 1);
        }
        for(int j = cols-2; j >=0; j--) {
            life[rows-1][j] = Math.max(life[rows-1][j+1] - dungeon[rows-1][j], 1);
        }

        for(int i = rows -2; i >=0; --i)
            for(int j = cols-2; j >=0; --j)
            {
                life[i][j] = Math.max ( Math.min( life[i+1][j], life[i][j+1]  ) - dungeon[i][j],
                        1 );
            }

        return life[0][0];
    }
}

