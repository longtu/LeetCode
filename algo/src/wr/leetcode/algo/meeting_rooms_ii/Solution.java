package wr.leetcode.algo.meeting_rooms_ii;

import wr.leetcode.algo.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution {

    /*
    //Sorting Solution
    //O(NLogN) time, O(N) space
    // Tricky CompareTo function
    public int minMeetingRooms0(Interval[] intervals) {
        if (null == intervals) {
            intervals = new Interval[0];
        }
        int n = intervals.length;
        int eventCount = n * 2;
        Event[] events = new Event[eventCount];
        int i = 0;
        for (Interval interval : intervals) {
            //BUG: typo +1 instead of -1
            events[i++] = new Event (interval.start, 1);
            events[i++] = new Event (interval.end, -1);
        }
        Arrays.sort(events);
        int max = 0;
        int count = 0;
        for (Event e : events) {
            count += e.count;
            max = Math.max(count, max);
        }
        return max;
    }
    class Event implements Comparable<Event>{
        int time;
        int count;
        public Event ( int time, int count) {
            this.time = time;
            this.count = count;
        }

        public int compareTo(Event other) {
            if(this.time == other.time) {
                return this.count - other.count;
            } else {
                return this.time-other.time;
            }

        }
    }

    //Heap solution
    //0(NLogN) time, O(N) space
    // easier to code
    // Good framework for general event processing
    public int minMeetingRooms(Interval[] intervals) {
        if (null == intervals) {
            intervals = new Interval[0];
        }
        //BUG: sort first
        Arrays.sort(intervals, (a,b)->(a.start-b.start));

        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b)->(a.end-b.end));
        int max = 0;
        for (Interval interval : intervals) {
            while (!heap.isEmpty() && heap.peek().end <= interval.start) {
                heap.poll();
            }
            heap.offer(interval);
            //Typo: max instead of 0
            max = Math.max(max, heap.size());
        }
        return max;
    }

    //There is similar problem, schedule most events that has no conflict, using greedy to find the event that finishes
    //earlist,

    //Is there greedy solution for this problem?
    */

    public int minMeetingRooms(Interval[] intervals) {
        intervals = (null == intervals)?(new Interval[0]):(intervals);
        Queue<Event> heap = new PriorityQueue<>((a,b)->(a.time-b.time));

        for (Interval itv : intervals) {
            heap.offer(new Event(itv.start, 1));
            heap.offer(new Event(itv.end, -1));
        }
        int max = 0;
        int count = 0;
        int t = 0;
        while(!heap.isEmpty()) {
            Event event = heap.poll();
            t = event.time;
            count += event.count;
            while( !heap.isEmpty() && heap.peek().time == t) {
                count += heap.poll().count;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    class Event {
        public Event(int time, int count) {
            this.time = time;
            this.count = count;
        }
        int time;
        int count;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        Interval [] meetings = {
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
        };

        System.out.println(sol.minMeetingRooms(meetings));
    }
}



