package wr.leetcode.algo.strobogrammatic_number_ii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findStrobogrammatic(int n) {

        if(0 >= n ) {
            return new LinkedList<>();
        }

        Map<Integer, Integer> dict = pairs();
        LinkedList<String> [] dp = new LinkedList[3];
        for (int i = 0; i <=n; ++i) {
            LinkedList<String> res = new LinkedList<>();
            if( 0 == i ) {
                res.add("");
            } else if ( 1 == i ) {
                //BUG: not all of the pairs!!!
                /*for (Integer k : dict.keySet()) {
                    res.add(Integer.toString(k));
                }*/
                for (Map.Entry<Integer, Integer> e : dict.entrySet()) {
                    if(e.getValue().equals(e.getKey())) {
                        res.add(e.getKey().toString());
                    }
                }
            } else {
                for (String prev : dp[(i-2)%3] ) {
                    for (Map.Entry<Integer, Integer> e : dict.entrySet()) {
                        res.add(e.getKey() + prev + e.getValue());
                    }
                }
            }

            dp[i%3] = res;
        }
        //BUG: 0* is not a number, need to fix from here instead of recursive
        return filterNumbers(dp[n%3]);
    }

    //need to filter out leading 0s
    public List<String> filterNumbers( List<String> numbers ) {
        return numbers.stream()
                .filter(a->( !a.startsWith("0") || a.equals("0") ))
                .collect(Collectors.toList());
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

        for (int i = 0; i <= 5; ++i) {
            System.out.println(sol.findStrobogrammatic(i));
        }

    }

}
