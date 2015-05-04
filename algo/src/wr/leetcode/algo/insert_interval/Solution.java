package wr.leetcode.algo.insert_interval;

import wr.leetcode.algo.Interval;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(null == intervals){
            intervals = new LinkedList();
        }
        List<Interval> ret = new LinkedList();

        while(!intervals.isEmpty()) {
            Interval next = intervals.remove(0);
            if(isOverlap(newInterval, next)){
                newInterval = mergeInterval(newInterval, next);
            } else {
                if(newInterval != null && next.start > newInterval.end) {
                    ret.add(newInterval);
                    newInterval = null;
                }
                ret.add(next);
            }
        }
        // this is very easy to forget!!
        if(newInterval != null){
            ret.add(newInterval);
        }
        return ret;
    }

    private Interval mergeInterval(Interval src, Interval dest) {
        if(!isOverlap(src,dest)) {
            throw new IllegalArgumentException("Trying to merge non-overlap intervals");
        }
        return new Interval(Math.min(src.start, dest.start),
                Math.max(src.end, dest.end));
    }

    private boolean isOverlap(Interval src, Interval dest) {
        if(null == src || dest == null){
            return false;
        }
        if(src.start > dest.start) {
            return isOverlap(dest, src);
        }
        return  (src.start - dest.start) * (src.end - dest.start) <= 0;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Interval> test = new LinkedList<>();
        test.add(new Interval(1,2));
        test.add(new Interval(3,5));
        test.add(new Interval(6,7));
        test.add(new Interval(8,10));
        test.add(new Interval(12,16));
        System.out.println(sol
                .insert(test, new Interval(4,9)));
    }
}
