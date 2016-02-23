package wr.leetcode.algo.airbnb;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KDistanceSort {

    int[] sort(int[] input, int k) {
        input = (null == input)?(new int[0]):(input);
        Queue<Integer> queue = new PriorityQueue<>();
        int n = input.length;

        int [] ret = new int[n];
        int w = 0;
        for (int anInput : input) {
            queue.offer(anInput);
            if (queue.size() > k) {
                ret[w++] = queue.poll();
            }
        }
        while(queue.size() > 0) {
            ret[w++] = queue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3,6,5,4,9,8,7},
                {2,1},
                {1,2},
                {3,2,1},
                {3,2,1,6,5},
                {3,2,1,5,6},
                {3,2,1,6}
        };
        KDistanceSort sort = new KDistanceSort();

        for (int[] input : inputs) {
            System.out.println(Arrays.toString(sort.sort(input, 3)));
        }
    }
}
