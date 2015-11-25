package wr.leetcode.algo.find_median_from_data_stream;

import java.util.PriorityQueue;

public class MedianFinder {

    //BUG: usage of priority queue: poll() pulls the smallest according to the order
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

    // Adds a number into the data structure.
    public void addNum(int num) {
        //BUG: !!!! need to check median to put into the right heap!!!
        minHeap.add(num);
        if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }

        //BUG: potentially put the minHeap breaks the order, we need to rebalance!
        if(minHeap.size() > 0 && maxHeap.size() > 0) {
            if(minHeap.peek() <  maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();
        if(0 == totalSize) {
            throw new IllegalStateException("No elements!");
        }
        double val;
        if(1 == totalSize % 2) {
            val = minHeap.peek();
        } else {
            val = (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return val;
    }

    public static void main(String[] args) {
        MedianFinder sol = new MedianFinder();
        sol.addNum(1);
        sol.addNum(2);
        System.out.println(sol.findMedian());
        sol.addNum(3);
        System.out.println(sol.findMedian());
    }
}
