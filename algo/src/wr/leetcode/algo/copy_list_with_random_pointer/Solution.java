package wr.leetcode.algo.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        Map<RandomListNode, RandomListNode> copy = new HashMap();
        copy.put(null,null);
        RandomListNode helper = new RandomListNode(-1);
        helper.next = head;
        RandomListNode node = helper;

        while(null != node.next) {
            node = node.next;
            copy.put(node, new RandomListNode(node.label));
        }

        node = helper;
        while(null != node.next) {
            node = node.next;
            copy.get(node).next = copy.get(node.next);
            copy.get(node).random = copy.get(node.random);
        }
        return copy.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};