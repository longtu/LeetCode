package wr.leetcode.algo.Facebook;

import java.util.*;

/**
 *
 电面题目是task scheduler，举例如下：
 Tasks: AABABCD
 Cooldown Time: 2
 A__AB_ABCD
 Output: 10
 就是说同样类型的task之间至少要等2，每个task的执行时间是1
 followup: 如果cooldown是个参数，也就是说有可能会很长时间，怎么修改之前的程序
 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=161904&extra=page%3D2%26filter%3Dsortid%26sortid%3D311&page=2
 
 */
public class TaskScheduler {


    /**
     * Not that complicated! Consider hashtable
     *
     * time O(input task list)
     * space O(Task type)
     */
    public int taskSchedule(char[] tasks, int k) {
        Map<Character, Integer> schedule = new HashMap<>();
        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            char task = tasks[i];
            if ( schedule.containsKey(task) ){
                int t = schedule.get(task);
                if(t > time) {
                    time = t;
                }
            }
            schedule.put(task, time + k + 1);
            time += 1;
        }
        return time;
    }

    /**
     * What if the tasks no need to execute in order?
     *
     * TODO: improve to fast skip the time with no events:
     *  fast skip t when at t:
     *   runqueue is empty
     *   no scheduled events in queue
     *
     * can add another queue as next events.
     *
     * TODO: 我的思路是count所有的task，然后找到count最大的task的个数，
     * 那么总时间不小于(max-1)*(interval+1)+countOfMax. 返回这个总时间和数组总长度的较大者。
     * 
     */
    public int taskScheduleNoOrder(String taskStr, int k) {

        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char ch : taskStr.toCharArray()) {
            int cnt = taskCounts.getOrDefault(ch, 0) + 1;
            taskCounts.put(ch, cnt);
        }

        Queue<RunQueueEntry> runQueue = new PriorityQueue<>((a,b)->(
                b.remaining.compareTo(a.remaining) ));

        //scheduled task
        Map<Integer, List<Character>> time = new HashMap<>();
        List<Character> tasks = new LinkedList<>(taskCounts.keySet());
        time.put(0, tasks);

        int t = 0;

        while( !taskCounts.isEmpty() || !runQueue.isEmpty()) {
            List<Character> executables = time.getOrDefault(t, new LinkedList<>());
            time.remove(t);
            for (Character task : executables) {
                runQueue.offer(new RunQueueEntry(
                        taskCounts.get(task),
                        task));
            }
            //every task in runqueue is executable
            if(!runQueue.isEmpty()) {
                RunQueueEntry entry = runQueue.poll();
                Character task = entry.taskId;
                System.out.println( t + ":" + task);
                int cnt = taskCounts.get(task)-1;
                if(cnt == 0) {
                    taskCounts.remove(task);
                } else {
                    taskCounts.put(task, cnt);
                    int nextTime = t + k + 1;
                    List<Character> futureTasks = time.getOrDefault(nextTime, new LinkedList<>());
                    futureTasks.add(task);
                    time.put(nextTime, futureTasks);
                }
            }
            t++;
        }
        return t;
    }

    class RunQueueEntry {
        Integer remaining;
        Character taskId;

        public RunQueueEntry (int remaining, Character taskId) {
            this.remaining = remaining;
            this.taskId = taskId;
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.taskSchedule("ABABA".toCharArray(), 3));
        //System.out.println(scheduler.taskScheduleNoOrder("AABABCD", 10));
    }
}
