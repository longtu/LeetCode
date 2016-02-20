package wr.leetcode.algo.the_skyline_problem;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<int[]> ret = new LinkedList<>();
        if (n == 1) {
            int[] b = buildings[0];
            int [] left = {b[0], b[2]};
            int [] right = {b[1], 0};
            ret.add(left);
            ret.add(right);
        } else if (n > 1) {
            int half = (n+1)/2;
            List<int[]> leftLine = getSkyline(Arrays.copyOfRange(buildings, 0, half));
            List<int[]> rightLine = getSkyline(Arrays.copyOfRange(buildings, half, n));
            ret = merge(leftLine, rightLine);
        }
        return ret;
    }

    public List<int[]> merge(List<int[]> left, List<int[]> right) {
        LinkedList<int[]> ret = new LinkedList<>();
        int lh = 0;
        int rh = 0;

        while(!left.isEmpty() || !right.isEmpty()) {
            int x;
            if(!left.isEmpty() && !right.isEmpty()) {
                int lx = left.get(0)[0];
                int rx = right.get(0)[0];
                if (lx == rx) {
                    lh = left.remove(0)[1];
                    rh = right.remove(0)[1];
                    x = lx;
                }else if (lx <= rx) {
                    lh = left.remove(0)[1];
                    x = lx;
                } else {
                    rh = right.remove(0)[1];
                    x = rx;
                }
            } else if (!left.isEmpty()) {
                int[] p = left.remove(0);
                x = p[0];
                lh = p[1];
            } else {
                int[] p = right.remove(0);
                x = p[0];
                rh = p[1];
            }
            int h = Math.max(lh, rh);
            if (ret.isEmpty() || ret.getLast()[1] != h) {
                ret.add(new int[] {x, h} );
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] buildings0 = {{0, 2, 3}};
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings2 = {{2, 9, 10}};
        int[][] buildings3 = {};
        int[][] buildings4 = {{0, 2, 3}, {2, 5, 3}};
        int[][] buildings5 = {{1, 2, 1}, {1, 2, 2}, {1, 2, 3}};
        int[][] buildings6 = {{2, 4, 7},{2, 4, 5},{2, 4, 6}};

        toString(sol.getSkyline(buildings0));
        toString(sol.getSkyline(buildings1));
        toString(sol.getSkyline(buildings2));
        toString(sol.getSkyline(buildings3));
        toString(sol.getSkyline(buildings4));
        toString(sol.getSkyline(buildings5));
        toString(sol.getSkyline(buildings6));

    }

    public static void toString(List<int[]> sols) {
        for (int[] sol : sols) {
            System.out.print(Arrays.toString(sol));
        }
        System.out.println();
    }
/*
    public List<int[]> getSkyline(int[][] buildings, int start, int end) {

        List<int[]> ret = new LinkedList<>();
        if(start <= end ) {
            int mid = start + ((end - start)>>1);
            //BUG: if(mid == start) not equals to size 1
            if(end == start){
                int [] b = buildings[mid];
                ret.add( new int[] { b[0], b[2]});
                ret.add( new int[] { b[1], 0});
            } else {
                List<int[]> lefts = getSkyline(buildings, start, mid);
                List<int[]> rights = getSkyline(buildings, mid + 1, end);
                ret = merge(lefts,rights);
            }
        }
        return ret;
    }

    public List<int[]> merge(List<int[]> lefts, List<int[]> rights) {
        LinkedList<int[]> ret = new LinkedList<>();
        ret.add(new int[] {Integer.MIN_VALUE, 0});


        int lh = 0;
        int rh = 0;
        int[] curr;
        while(!lefts.isEmpty() || !rights.isEmpty()) {
            curr = ret.getLast();
            int[] next;
            if(!lefts.isEmpty() && !rights.isEmpty()) {
                if (lefts.get(0)[0] <= rights.get(0)[0]) {
                    next = lefts.remove(0);
                    //BUG: should be updated instead of Math.max
                    lh = next[1];
                } else {
                    next = rights.remove(0);
                    //BUG: should be updated instead of Math.max
                    rh = next[1];
                }
            } else if ( !lefts.isEmpty() ) {
                next = lefts.remove(0);
                //BUG: should be updated instead of Math.max
                lh = next[1];
            } else { // only right is not empty
                next = rights.remove(0);
                //BUG: should be updated instead of Math.max
                rh = next[1];
            }

            int x = next[0];
            int h = Math.max(lh, rh);

            if (h != curr[1]) {
                if(x == curr[0]) {
                    curr[1] = h;
                    //BUG: for(x == curr[0]){
                    while(true){
                        int[] last = ret.removeLast();
                        if(ret.getLast()[1] != last[1]){
                            ret.addLast(last);
                            break;
                        }
                    }
                } else {
                    ret.add(new int[]{x, h});
                }
            }
        }
        ret.removeFirst();
        return ret;
    }


    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new LinkedList<>();
        if(null != buildings && buildings.length > 0 ) {
            ret = getSkyline(buildings, 0, buildings.length-1);
        }
        return ret;
    }*/
}




/*
public class Solution {





    public List<int[]> getSkyline(int[][] buildings) {

    }
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
*/