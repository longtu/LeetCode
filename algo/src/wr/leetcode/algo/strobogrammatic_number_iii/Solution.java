package wr.leetcode.algo.strobogrammatic_number_iii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int strobogrammaticInRange(String low, String high) {

        low = notNull(low);
        high = notNull(high);
        int ln = low.length();
        int hn = high.length();
        Map<Integer, Integer> dict = pairs();

        LinkedList<String> [] dp = new LinkedList[hn+1];
        for (int i = 0; i <=hn; ++i) {
            LinkedList<String> res = new LinkedList<>();
            if( 0 == i ) {
                res.add("");
            } else if ( 1 == i ) {
                for (Map.Entry<Integer, Integer> e : dict.entrySet()) {
                    if(e.getValue().equals(e.getKey())) {
                        res.add(e.getKey().toString());
                    }
                }
            } else {
                for (String prev : dp[(i-2)] ) {
                    for (Map.Entry<Integer, Integer> e : dict.entrySet()) {
                        res.add(e.getKey() + prev + e.getValue());
                    }
                }
            }

            dp[i] = res;
        }

        int ret = 0;
        for (int i = ln; i <= hn; ++i) {
            ret += filterNumbers(dp[i], i, low, high);
        }
        return ret;
    }

    String notNull(String val) {
        return (null == val || val.isEmpty())? ("0") : (val);
    }

    public int filterNumbers( List<String> numbers, int len, String low, String high ) {
        int count = 0;
        for (String n : numbers) {
            if( n.startsWith("0") && !n.equals("0")) {
                continue;
            }
            if (len == low.length() && n.compareTo(low) < 0) {
                continue;
            }
            if (len == high.length() && n.compareTo(high) > 0) {
                continue;
            }
            count ++;
        }
        return count;
    }

    public Map<Integer, Integer> pairs() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        return map;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strobogrammaticInRange("50", "100"));
    }
}
