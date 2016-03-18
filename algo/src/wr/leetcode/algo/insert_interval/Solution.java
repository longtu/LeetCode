package wr.leetcode.algo.insert_interval;

import wr.leetcode.algo.Interval;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {

    /*
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new LinkedList<>();
        if( null == intervals ) {
            intervals = new LinkedList<>();
        }
        for (Interval interval : intervals) {
            if ( null == newInterval ) { // already processed
                ret.add(interval);
            } else {
                if (interval.end < newInterval.start) {
                    ret.add(interval);
                } else if (interval.start > newInterval.end) {
                    ret.add(newInterval);
                    newInterval = null;
                    ret.add(interval);
                } else {
                    newInterval = merge(interval, newInterval);
                }
            }
        }
        if (null != newInterval) {
            ret.add(newInterval);
        }
        return ret;
    }

    public Interval merge(Interval left, Interval right) {
        return new Interval(Math.min(left.start, right.start),
                Math.max(left.end, right.end));
    }

    /*public List<Interval> insert0(List<Interval> intervals, Interval newInterval) {
        intervals = (null == intervals)?(new LinkedList<>()):(intervals);
        LinkedList<Interval> ret = new LinkedList<>();

        if(null != newInterval) {
            for (Interval node : intervals){
                if(overlaps(node, newInterval)){
                    newInterval = merge( newInterval, node);
                } else {
                    ret.add(node);
                }
            }
            int i = 0;
            boolean found = false;
            for (Interval node : ret) {
                if(node.start > newInterval.start) {
                    ret.add(i, newInterval);
                    found = true;
                    break;
                }
                i++;
            }
            if(!found) {
                ret.add(newInterval);
            }

        }
        return ret;
    }

    // this makes sure left start <= right start
    public boolean overlaps ( Interval left, Interval right) {
        //BUG: has to check both direction
        if(left.start > right.start) {
            return overlaps(right,left);
        }
        return (left.start - right.start) * (left.end - right.start) <= 0;
    }


    public Interval merge ( Interval left, Interval right) {
        int start = Math.min(left.start, right.start);
        int end = Math.max(left.end, right.end);
        return new Interval(start, end);
    }




    /*
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



    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //intervals is not null, newInterval is valid
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        List<Interval> ret = new LinkedList<>();

        for (Interval interval : intervals) {
            if( null == newInterval) {
                ret.add(interval);
            } else if (interval.end < newInterval.start ) {
                ret.add(interval);
            } else if (interval.start > newInterval.end ) {
                ret.add(newInterval);
                ret.add(interval);
                newInterval = null;
            } else {
                newInterval = merge(newInterval, interval);
            }
        }
        if(null != newInterval) {
            ret.add(newInterval);
        }
        return ret;
    }*/

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ListIterator<Interval> ite = intervals.listIterator();
        while(ite.hasNext()) {
            Interval curr = ite.next();
            if(null == newInterval) {
                break;
            } else if (curr.end < newInterval.start ) {
                continue;
            } else if (curr.start > newInterval.end) {
                ite.remove();
                ite.add(newInterval);
                ite.add(curr);
                newInterval = null;
            } else {
                newInterval = new Interval(Math.min(curr.start, newInterval.start), Math.max(curr.end, newInterval.end));
                ite.remove();
            }
        }
        if(null != newInterval) {
            intervals.add(newInterval);
        }

        return intervals;
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
