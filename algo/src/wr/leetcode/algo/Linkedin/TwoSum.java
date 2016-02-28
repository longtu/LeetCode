package wr.leetcode.algo.Linkedin;

import java.util.*;

public class TwoSum {
    Map<Integer, Integer> data = new HashMap<>();


    Set<Integer> cache = new HashSet<>();
    ArrayList<Integer> dataList = new ArrayList<>();
    /**
     * Stores @param input in an internal data structure.
     *
     * O(1)
     */
    void store(int input) {
        int cnt = data.getOrDefault(input, 0);
        data.put(input, cnt+1);
    }
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     *
     * O(N)
     */

    boolean test(int val) {
        Set<Integer> keys = data.keySet();
        boolean ret = false;
        for (int key : keys){
            int oppsite = val - key;
            if (data.containsKey(oppsite)) {
                ret = (oppsite != key) || ( data.get(key) > 1);
            }
            if(ret) {
                break;
            }
        }
        return ret;
    }


    /**
     * Follow up: speedup the test process?
     */

    void storeWithCache(int input) {
        for (int v : dataList) {
            cache.add(v + input);
        }
        dataList.add(input);
    }

    boolean testWithCache (int val) {
        return cache.contains(val);
    }

}