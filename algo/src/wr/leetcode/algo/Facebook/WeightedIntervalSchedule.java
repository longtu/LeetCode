package wr.leetcode.algo.Facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
}

public class WeightedIntervalSchedule {

    public int maxCost (Task[] tasks) {
        int ret = 0;
        if (null != tasks && tasks.length > 0) {
            int n = tasks.length;
            int [] dp = new int[n+1];
            int [] path = new int[n+1];

            Arrays.sort(tasks, (a, b) -> (a.end - b.end));

            for (int i = 1; i <=n; ++i) {
                Task curr = tasks[i-1];
                int loc = curr.cost;
                int latest = latestNoOverlap(tasks, i-1);
                loc += dp[latest+1];
                if (loc > dp[i-1]) {
                    dp[i] = loc;
                    path[i] = latest+1;
                } else {
                    dp[i] = dp[i-1];
                    path[i] = i-1;
                }
            }
            List<String> paths = generatePath(path,tasks, n);
            System.out.println(paths.stream().collect(Collectors.joining(",")));
            ret = dp[n];
        }
        return ret;
    }

    public List<String> generatePath( int[] path, Task[] tasks, int end) {
        List<String> ret = new LinkedList<>();
        if ( 0 < end) {
            Task task = tasks[end-1];
            ret = generatePath(path, tasks, path[end]);
            int parentIndex = path[end]-1;
            if(parentIndex >= 0) {
                Task parent = tasks[parentIndex];
                if(Math.max(task.start, parent.start) >= Math.min(task.end, parent.end)) {
                    ret.add(String.format("[%s, %s, %s]",task.start, task.end, task.cost ));
                }
            } else {
                ret.add(String.format("[%s, %s, %s]",task.start, task.end, task.cost ));
            }
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
                 new Task(6,7,3),
                 new Task(0,6,3),
                 new Task(2,10,4)},
                {},
                { new Task(2,5,2), new Task(6,7,3),}
        };
        for (Task[] tasks: events) {
            System.out.println(sol.maxCost(tasks));
            System.out.println("---");
        }
    }
}
