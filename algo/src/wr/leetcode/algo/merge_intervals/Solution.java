package wr.leetcode.algo.merge_intervals;

import wr.leetcode.algo.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList();

        if(null == intervals) {
            return ret;
        }
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start) {
                    return o1.start - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comp);

        while(!intervals.isEmpty()) {
            Interval merged = intervals.remove(0);
            while(!intervals.isEmpty()) {
                Interval next = intervals.get(0);
                if(isOverlap(merged, next)) {
                    intervals.remove(0);
                    merged = mergeInterval(merged, next);
                } else {
                    break;
                }
            }
            ret.add(merged);
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
        test.add(new Interval(1,3));
        test.add(new Interval(2,6));
        test.add(new Interval(8,10));
        test.add(new Interval(15,8));
        System.out.println(sol
        .merge(test));
    }
}