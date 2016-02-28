package wr.leetcode.algo.Linkedin;


public class FlattenListNode {


    //method1: using a queue


    //method2: update tail

    public void flatten(MultiLevelListNode root) {
        if( null == root) {
            return;
        }

        MultiLevelListNode tail = root;
        while(null != tail.next) {
            tail = tail.next;
        }

        MultiLevelListNode node = root;
        while(null != node) {
            if (node.child != null) {
                tail.next = node.child;
                while(null != tail.next) {
                    tail = tail.next;
                }
                node.child = null;
            }
            node = node.next;
        }
    }
}



class MultiLevelListNode {
    int data;
    MultiLevelListNode next;
    MultiLevelListNode child;
}


