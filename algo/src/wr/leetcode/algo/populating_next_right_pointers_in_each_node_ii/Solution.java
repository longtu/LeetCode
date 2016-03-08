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

    public void connect0(TreeLinkNode root) {
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
                    node.left.next = (null != node.right) ? (node.right):(nextSibling0(node));
                }
                if(null != node.right) {
                    node.right.next = (nextSibling0(node));
                }
                node = node.next;
            }
        }
    }

    public TreeLinkNode nextSibling0 (TreeLinkNode parent) {
        TreeLinkNode node = parent.next;
        TreeLinkNode ret = null;
        while(null != node && null == ret) {
            ret = (null != node.left) ? (node.left) :
                  (null != node.right) ? (node.right) : null;
            node = node.next;
        }
        return ret;
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        while( null != parent) {
            TreeLinkNode child = null;
            while ( null != parent) {
                if (null == child && null != parent.left ) {
                    child = parent.left;
                }
                if (null == child && null != parent.right) {
                    child = parent.right;
                }
                if (null != parent.left ) {
                    parent.left.next = (null != parent.right)?(parent.right):(nextSibling(parent));
                }
                if (null != parent.right) {
                    parent.right.next = (nextSibling(parent));
                }
                parent = parent.next;
            }
            parent = child;
        }
    }
    public TreeLinkNode nextSibling (TreeLinkNode parent) {
        TreeLinkNode ret = null;
        TreeLinkNode uncle = parent.next;
        while (null != uncle && null == ret) {
            if(null != uncle.left) {
                ret = uncle.left;
            }
            if(null == ret && null != uncle.right) {
                ret = uncle.right;
            }
            uncle = uncle.next;
        }
        return ret;
    }*/
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextStart = root;

        while(null != nextStart) {
            TreeLinkNode parent = nextStart;
            nextStart = null;
            while(null != parent) {
                if (null == nextStart){
                    nextStart = (null != parent.left)?(parent.left):
                            (null != parent.right)?(parent.right):(null);
                }
                if (null != parent.left) {
                    if(null != parent.right) {
                        parent.left.next = parent.right;
                    } else {
                        parent.left.next = nextSibling(parent);
                    }
                }
                if (null != parent.right) {
                    parent.right.next = nextSibling(parent);
                }
                parent = parent.next;
            }
        }
    }

    private TreeLinkNode nextSibling(TreeLinkNode parent) {
        TreeLinkNode ret = null;
        TreeLinkNode node = parent.next;
        while(null != node) {
            if (null != node.left ) {
                ret = node.left;
                break;
            }
            if(null != node.right) {
                ret = node.right;
                break;
            }
            node = node.next;
        }
        return ret;
    }

}