package wr.leetcode.algo.nim_game;

public class Solution {
    public boolean canWinNim(int n) {
        boolean ret = false;
        if (n > 0) {
            //BUG: space limit exceed, it's actually loop
            ret = (0 == n%4)?(false):(true);
        }
        return ret;
    }
}
