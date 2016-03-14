package wr.leetcode.algo.Facebook;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MinKeyStrikes {


    /**
     * frequency and keysize array have no specific orders
     *
     */
    public int minKeyStrikes(int[] keysize, int[] frequency) {
        PriorityQueue<Integer> keyCounts = new PriorityQueue<>();
        for (int key: keysize) {
            for (int i = 1; i <=key; ++i) {
                keyCounts.offer(i);
            }
        }
        Arrays.sort(frequency);
        int n = frequency.length;
        int sum = 0;
        for (int i = n-1; i >=0; --i) {
            sum += keyCounts.poll() * frequency[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MinKeyStrikes sol = new MinKeyStrikes();

        int[] keySize = {3,1,2};
        int[] freq = {3,3,3,2,1,1};
        System.out.println(sol.minKeyStrikes( keySize, freq));
    }

    /**
     * Follow up, what if the order frequency
     *
     * http://www.cnblogs.com/skyivben/archive/2011/11/09/2243068.html
     */


}
