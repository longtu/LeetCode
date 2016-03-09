package wr.leetcode.algo.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 *
 电面题目是task scheduler，举例如下：
 Tasks: AABABCD
 Cooldown Time: 2
 A__AB_ABCD
 Output: 10
 就是说同样类型的task之间至少要等2，每个task的执行时间是1
 followup: 如果cooldown是个参数，也就是说有可能会很长时间，怎么修改之前的程序
 */
public class TaskScheduler {

    /*cool down time is 2*/
    public int taskSchedule(char [] tasks ) {
        int t = 0;
        if( null == tasks || tasks.length == 0) {
            return t;
        }

        int i = 0;
        Character [] history = new Character[3];
        while( i < tasks.length ) {
            Character task = tasks[i];
            boolean needsWait = false;
            for (int j = 1; j<=2; ++j) {
                if (task.equals(history[(t-j+3)%3])) {
                    needsWait = true;
                }
            }
            if(needsWait) {
                history[t%3] = null;
            } else {
                history[t%3] = task;
                i++;
            }
            t++;
        }
        return t;
    }

    /*cool down time is k */
    public int taskSchedule(char [] tasks, int cooldown ) {
        int t = 0;
        if( null == tasks || tasks.length == 0) {
            return t;
        }

        int i = 0;
        int mod = cooldown + 1;
        Character [] history = new Character[mod];
        Map<Character, Integer> tasksCounts = new HashMap<>();
        while( i < tasks.length ) {
            Character task = tasks[i];
            if( t - cooldown -1 >= 0) {
                Character tsk = history[(mod + t-cooldown-1)%mod];
                if( null != tsk) {
                    int cnt = tasksCounts.get(tsk) - 1;
                    if (cnt == 0) {
                        tasksCounts.remove(tsk);
                    } else {
                        tasksCounts.put(tsk, cnt);
                    }
                }
            }

            boolean needsWait = tasksCounts.containsKey(task);
            if(needsWait) {
                history[t%mod] = null;
            } else {
                history[t%mod] = task;
                int cnt = tasksCounts.getOrDefault(task, 0) + 1;
                tasksCounts.put(task, cnt);
                i++;
            }
            t++;
        }
        return t;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.taskSchedule("AABABCD".toCharArray()));
        System.out.println(scheduler.taskSchedule("AABABCD".toCharArray(), 2));
    }
}
