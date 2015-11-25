package wr.leetcode.algo.merge_k_sorted_lists;

import wr.leetcode.algo.ListNode;

import java.util.Arrays;
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

    public ListNode mergeKLists0(List<ListNode> lists) {
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

    public ListNode mergeKLists(ListNode [] lists) {
        ListNode helper = new ListNode(-1);
        ListNode head = helper;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (a,b)->(a.val - b.val)
        );

        Arrays.stream(lists)
                .filter( l -> (null != l))
                .forEach(heap::add);

        while(!heap.isEmpty()) {
            ListNode node = heap.remove();
            head.next = node;
            if( null != node.next ) {
                heap.add(node.next);
            }
            head = head.next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.mergeKLists(null));
    }


}