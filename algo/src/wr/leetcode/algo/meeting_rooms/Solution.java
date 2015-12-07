package wr.leetcode.algo.meeting_rooms;

import wr.leetcode.algo.Interval;

import java.util.Arrays;

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        boolean ret = true;
        if(null != intervals) {
            Arrays.sort(intervals, (a,b)->(a.start-b.start));
            int n = intervals.length;
            for (int i = 0; i < n-1; ++i) {
                Interval left = intervals[i];
                Interval right = intervals[i+1];
                if(right.start < left.end) {
                    ret = false;
                    break;
                }
            }
        }
        return ret;
    }
}
