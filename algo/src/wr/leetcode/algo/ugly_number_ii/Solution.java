package wr.leetcode.algo.ugly_number_ii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    /*
    public int nthUglyNumber(int n) {
        Map<Integer, Integer> res = new HashMap<>();
        res.put(0,1);
        int lastTwo = 0;
        int lastThree = 0;
        int lastFive = 0;

        for (int i = 1; i < n; ++i) {
            int min = min( res.get(lastTwo)*2, res.get(lastThree)*3, res.get(lastFive)*5);
            res.put(i, min);
            if( min == res.get(lastTwo)*2) {
                lastTwo += 1;
            }
            if( min == res.get(lastThree)*3) {
                lastThree += 1;
            }
            if( min == res.get(lastFive)*5) {
                res.remove(lastFive);
                lastFive += 1;
            }
        }
        return res.get(n-1);
    }


    */
    public int min (int a, int b, int c) {
        return Math.min(Math.min(a,b), c);
    }

    public int nthUglyNumber(int n) {

        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();

        int ret = 1;
        for (int i = 1; i <=n; ++i) {
            if(1 == i) {
                ret = 1;
            } else {
                ret = min(q2.peek(), q3.peek(), q5.peek());
            }
            q2.add(ret*2);
            q3.add(ret*3);
            q5.add(ret*5);
            if(q2.peek() == ret){
                q2.remove();
            }
            if(q3.peek() == ret){
                q3.remove();
            }
            if(q5.peek() == ret){
                q5.remove();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i = 1; i < 11; ++i) {
            System.out.println(sol.nthUglyNumber(i));
        }
    }
}
