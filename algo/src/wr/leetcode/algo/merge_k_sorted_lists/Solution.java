package wr.leetcode.algo.merge_k_sorted_lists;

import wr.leetcode.algo.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    class MetaData implements Comparable{
        public ListNode curr;
        public ListNode next;
        public MetaData(ListNode curr, ListNode next) {
            this.curr = curr;
            this.next = next;
        }
        @Override
        public int compareTo(Object o) {
            return this.curr.val - ((MetaData)o).curr.val;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode helper = new ListNode(-1);
        ListNode head = helper;
        PriorityQueue<MetaData> heap = new PriorityQueue();
        for (ListNode listHead : lists) {
            heap.add(new MetaData(listHead, listHead.next));
        }
        while(!heap.isEmpty()) {
            MetaData node = heap.remove();
            helper.next = node.curr;
            helper = helper.next;
            if(node.next != null) {
                heap.add(new MetaData(node.next, node.next.next));
            }
        }
        return head.next;
    }
}