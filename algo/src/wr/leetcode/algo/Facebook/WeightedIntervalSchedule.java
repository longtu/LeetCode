package wr.leetcode.algo.Facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Task {
    int start;
    int end;
    int cost;
    public Task(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    @Override
    public String toString() {
        return String.format("[%s, %s, %s]", start, end, cost);
    }

}

public class WeightedIntervalSchedule {

    public int maxCost (Task[] tasks) {
        int ret = 0;
        if (null != tasks && tasks.length > 0) {
            int n = tasks.length;
            int [] dp = new int[n];
            int [] path = new int[n];

            Arrays.sort(tasks, (a, b) -> (a.end - b.end));

            for (int i = 0; i <n; ++i) {
                Task curr = tasks[i];
                int loc = curr.cost;
                int latest = latestNoOverlap(tasks, i);

                if (latest != -1) {
                    loc += dp[latest];
                }
                if (i > 0 && dp[i-1] > loc) {
                    dp[i] = dp[i-1];
                    path[i] = i-1;
                } else {
                    dp[i] = loc;
                    path[i] = latest;
                }
            }
            List<String> paths = generatePath(path,tasks);
            System.out.println(paths.stream().collect(Collectors.joining(",")));
            ret = dp[n-1];
        }
        return ret;
    }

    public List<String> generatePath( int[] path, Task[] tasks) {
        List<String> ret = new LinkedList<>();
        Stack<Task> st = new Stack<>();
        int i = path.length -1;

        while( i >= 0) {
            int prev = path[i];
            Task current = tasks[i];
            if( prev == -1 || tasks[prev].end <= current.start) {
                st.push(current);
            }
            i = prev;
        }

        while (!st.isEmpty()) {
            ret.add(st.pop().toString());
        }

        return ret;
    }

    public int latestNoOverlap( Task[] tasks, int current) {
        int ret = -1;
        int start = 0;
        int end = current - 1;
        int target = tasks[current].start;
        while(start <= end) {
            int mid = start + ((end - start)>>1);
            int time = tasks[mid].end;
            if (time > target) {
                end = mid - 1;
            } else {
                ret = mid;
                start = mid + 1;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        WeightedIntervalSchedule sol = new WeightedIntervalSchedule();

        Task [][] events = new Task[][] {
                {new Task(2,5,2)},
                {new Task(1,4,1),
                 new Task(2,5,2),
                 new Task(6,7,3),  //{063}, {673}
                 new Task(0,6,3),
                 new Task(2,10,4)},
                {},
                { new Task(2,5,2), new Task(6,7,3),} //{063}, {673}
        };
        for (Task[] tasks: events) {
            System.out.println(sol.maxCost(tasks));
            System.out.println("---");
        }
    }
}
