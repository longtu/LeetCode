package wr.leetcode.algo.gas_station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null == gas || gas.length == 0) {
            throw new IllegalArgumentException("Input array too small");
        }
        int n = gas.length;
        int [] fuel = new int[n];
        int total = 0;
        for (int i = 0; i< n; ++ i) {
            fuel[i] = gas[i] - cost[i];
            total += fuel[i];
        }
        int ret = -1;
        if(total < 0) {
            return ret;
        }
        for(int i = 0; i < n; ++i) {//N^2 solution TLE
            int sum = 0;
            boolean finish = true;
            for (int j = 0; j < n; ++j) {
                sum += fuel[ (i+j)% n ];
                if(sum < 0) {
                    finish = false;
                }
            }
            if(finish){
                ret = i;
                return ret;
            }
        }
        return ret;

    }
}
