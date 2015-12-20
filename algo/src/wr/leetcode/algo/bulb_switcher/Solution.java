package wr.leetcode.algo.bulb_switcher;

public class Solution {

    //TLE solution N^2
    public int bulbSwitch0(int n) {
        int on = 0;
        for (int i = 0; i < n; ++i) {
            int flip = 0;
            for (int mod = 1; mod <=n; ++mod) {
                if (mod-1 == i%mod) {
                    flip++;
                }
            }
            if(1 == flip%2){
                on ++;
            }
        }
        return on;
    }


    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bulbSwitch(3));
        System.out.println(sol.bulbSwitch(99999));
    }
}
