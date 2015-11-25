package wr.leetcode.algo.populating_next_right_pointers_in_each_node_ii;

import wr.leetcode.algo.TreeLinkNode;

public class Solution {
    /*
    public void connect(TreeLinkNode root) {

        TreeLinkNode parent = new TreeLinkNode(-1);
        parent.left = root;
        TreeLinkNode leftMost = parent.left;

        while(leftMost != null) {
            TreeLinkNode node = leftMost;
            while(node != null ){
                if(node == parent.left) {
                    if(parent.right != null) {
                        node.next = parent.right;
                    }
                    else {
                        TreeLinkNode uncle = nextCusinHasChild(parent);
                        node.next = nextCusin(uncle);
                        parent = uncle;
                    }
                } else {
                    TreeLinkNode uncle = nextCusinHasChild(parent);
                    node.next = nextCusin(uncle);
                    parent = uncle;
                }
                node = node.next;
            }
            parent = nextHasChild(leftMost);
            leftMost = nextCusin(parent);
        }

    }

    private TreeLinkNode nextCusinHasChild(TreeLinkNode node){
        return nextHasChild(node.next);
    }

    private TreeLinkNode nextHasChild(TreeLinkNode node){

        while(null != node) {
            if(null != node.left || null != node.right) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private TreeLinkNode nextCusin(TreeLinkNode uncle){
        if(null == uncle){
            return null;
        }else {
            return (null != uncle.left)?(uncle.left):(uncle.right);
        }
    }
    */
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextStart = root;

        while(null != nextStart) {
            TreeLinkNode node = nextStart;
            nextStart = null;
            while(null != node) {
                if(null == nextStart) {
                    if(null != node.right) {
                        nextStart = node.right;
                    }
                    if (null != node.left) {
                        nextStart = node.left;
                    }
                }
                if(null != node.left) {
                    node.left.next = (null != node.right) ? (node.right):(nextSibling(node));
                }
                if(null != node.right) {
                    node.right.next = (nextSibling(node));
                }
                node = node.next;
            }
        }
    }

    public TreeLinkNode nextSibling (TreeLinkNode parent) {
        TreeLinkNode node = parent.next;
        TreeLinkNode ret = null;
        while(null != node && null == ret) {
            ret = (null != node.left) ? (node.left) :
                  (null != node.right) ? (node.right) : null;
            node = node.next;
        }
        return ret;
    }

}