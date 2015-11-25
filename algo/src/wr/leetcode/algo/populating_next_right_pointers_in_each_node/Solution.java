package wr.leetcode.algo.populating_next_right_pointers_in_each_node;

import wr.leetcode.algo.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextStart = root;

        while(null != nextStart) {
            TreeLinkNode node = nextStart;
            nextStart = null;
            while(null != node) {
                if(null == nextStart) {
                    nextStart = node.left;
                }
                if(null != node.left) { /*BUG: NPE !!!!!!*/
                    node.left.next = node.right;
                }
                if(null != node.next && null != node.right) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
        }
    }
}
