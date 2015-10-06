package wr.leetcode.algo.the_skyline_problem;

import java.util.*;

//Let's redo this!!!!

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> ret = null;

        if(null != buildings) {
            PriorityQueue<Event> events = new PriorityQueue<>(
                    (a,b)->(a.x-b.x)
            );
            int i = 0;
            for (int[] building : buildings) {
                events.add(new Event(building[0],building[2],i,true));
                events.add(new Event(building[1],building[2],i,false));
                i++;
            }
            ret = processEvents(events);
        }
        return ret;
    }

    protected List<int[]> processEvents(PriorityQueue<Event> events) {
        LinkedList<int[]> ret = new LinkedList<>();
        PriorityQueue<Building> buildings = new PriorityQueue<>(
                (a,b) -> (b.height - a.height)
        );

        //priority queue iterator does not provide order
        while(!events.isEmpty()) {
            Event event = events.remove();
            int prevHeight = height(buildings);
            if(event.isStart) {
                buildings.add(new Building(event.height, event.buildId));
            } else {
                buildings.remove(new Building(event.height, event.buildId));
            }
            int height = height(buildings);
            if(height != prevHeight) {
                if(!ret.isEmpty()) {
                    int[] last = ret.removeLast();
                    if (last[0] == event.x) {
                        last[1] = height;
                        if (!ret.isEmpty() && ret.getLast()[1] == height) {
                            continue;
                        }
                        ret.addLast(last);
                    } else{
                        ret.addLast(last);
                        ret.add(new int[]{event.x, height});
                    }
                } else {
                    ret.add(new int[]{event.x, height});
                }
            }
        }
        return ret;
    }

    protected int height(PriorityQueue<Building> buildings) {
        int ret = 0;
        if (!buildings.isEmpty()) {
            ret = buildings.peek().height;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] buildings1 = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int [][] buildings2 = {{2,9,10}};
        int [][] buildings3 = {};
        int [][] buildings4 = {{0,2,3},{2,5,3}};
        int [][] buildings5 = {{1,2,1},{1,2,2},{1,2,3}};


        toString(sol.getSkyline(buildings1));
        toString(sol.getSkyline(buildings2));
        toString(sol.getSkyline(buildings3));
        toString(sol.getSkyline(buildings4));
        toString(sol.getSkyline(buildings5));

    }

    public static void toString(List<int[]> sols) {
        for (int[] sol : sols){
            System.out.print(Arrays.toString(sol));
        }
        System.out.println();
    }
}


class Building{

    public Building(int height, int buildId) {
        this.height = height;
        this.buildId = buildId;
    }

    int height;
    int buildId;

    @Override
    public boolean equals(Object other) {
        if(null != other && other instanceof Building) {
            Building o = (Building) other;
            return (this.buildId == o.buildId);
        }
        return false;

    }

}

class Event{

    public Event( int x, int height, int buildId, boolean isStart) {
        this.x = x;
        this.height = height;
        this.buildId = buildId;
        this.isStart = isStart;
    }

    int x;
    int height;
    int buildId;
    boolean isStart;
}