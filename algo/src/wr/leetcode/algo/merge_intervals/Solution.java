package wr.leetcode.algo.merge_intervals;

import wr.leetcode.algo.Interval;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if( null == intervals ) {
            intervals = new LinkedList<>();
        }
        Collections.sort(intervals, (a,b)->(a.start-b.start));
        LinkedList<Interval> ret = new LinkedList<>();
        for (Interval interval : intervals) {
            if (!ret.isEmpty() && overlaps(ret.getLast(), interval)) {
                interval = merge(ret.removeLast(), interval);
            }
            ret.add(interval);
        }
        return ret;
    }

    public boolean overlaps( Interval left, Interval right) {
        return (Math.min(left.end, right.end) >= Math.max(left.start, right.start));
    }

    public Interval merge(Interval left, Interval right) {
        return new Interval(Math.min(left.start, right.start),
                Math.max(left.end, right.end));
    }


    /*
    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals) {
            intervals = new LinkedList<>();
        }
        Collections.sort(intervals, (a,b)->(a.start - b.start));
        LinkedList<Interval> ret = new LinkedList<>();

        for (Interval interval : intervals) {
            if (ret.isEmpty()) {
                ret.add(interval);
            } else if (overlaps(ret.getLast(), interval)) { //overlaps
                Interval next = ret.removeLast();
                ret.addLast(merge(interval, next));
            } else {
                ret.add(interval);
            }
        }
        return ret;
    }

    public Interval merge(Interval left, Interval right) {
        return new Interval (Math.min(left.start, right.start), Math.max(left.end, right.end));
    }

    public boolean overlaps(Interval left, Interval right) {
        int maxStart = Math.max(left.start, right.start);
        int minEnd = Math.min(left.end, right.end);
        return maxStart <= minEnd;
    }

        /*

    public List<Interval> merge(List<Interval> intervals) {

        LinkedList<Interval> ret = new LinkedList<>();
        intervals = (null == intervals)?(new LinkedList<>()):(intervals);
        Collections.sort( intervals, (a,b)->(a.start - b.start));

        for ( Interval i : intervals) {
            merge(ret, i);
        }

        return ret;
    }

    public void merge(LinkedList<Interval> nodes, Interval node) {
        if( nodes.isEmpty() || !overlaps(nodes.peekLast(), node) ) {
            nodes.add(node);
        } else {
            merge(nodes.peekLast(), node);
        }
    }

    public boolean overlaps ( Interval left, Interval right) {
        return (left.start - right.start) * (left.end - right.start) <= 0;
    }

    public void merge ( Interval left, Interval right) {
        int start = Math.min(left.start, right.start);
        int end = Math.max(left.end, right.end);
        left.start = start;
        left.end = end;
    }




    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList();

        if(null == intervals) {
            return ret;
        }
        Collections.sort(intervals, (a,b)->(a.start-b.start));

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
    }*/

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