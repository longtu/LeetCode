package wr.leetcode.algo.two_sum_iii_data_structure_design;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    Map<Integer, Integer> counts = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        int cnt = counts.getOrDefault(number, 0) + 1;
        counts.put(number, cnt);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        boolean ret = false;
        for ( Integer m : counts.keySet() ) {
            int pair = value - m;
            if( counts.containsKey(pair) && (pair != m || counts.get(m) > 1) ) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        sol.add(1);
        sol.add(3);
        sol.add(5);

        System.out.println(sol.find(4));
        System.out.println(sol.find(7));

    }
}
