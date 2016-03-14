package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

class ListNode {
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
        this.value = val;
        this.prev = null;
        this.next = null;
    }
}

class Info {
    ListNode head;
    ListNode tail;

    public Info (ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }
}

class TreeInfo{
    TreeNode head;
    TreeNode tail;

    public TreeInfo (TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;
    }
}

public class Tree2DoublyLinkedList {

    ListNode tree2List(TreeNode root) {
        return tree2ListInfo(root).head;
    }

    Info tree2ListInfo( TreeNode root ) {
        Info info = new Info(null, null);
        if( null == root) {
            return info;
        }
        ListNode node = new ListNode(root.val);
        info = new Info(node, node);

        if( null != root.left) {
            Info leftInfo = tree2ListInfo(root.left);
            info.head = leftInfo.head;
            leftInfo.tail.next = node;
            node.prev = leftInfo.tail;
        }

        if (null != root.right) {
            Info rightInfo = tree2ListInfo(root.right);
            info.tail = rightInfo.tail;
            rightInfo.head.prev = node;
            node.next = rightInfo.head;
        }
        return info;
    }

    TreeNode flattenBST(TreeNode root) {
        return flattenBSTInfo(root).head;
    }

    TreeInfo flattenBSTInfo(TreeNode root) {
        TreeNode head = null;
        TreeNode tail = null;
        if( null != root ) {
            head = root;
            tail = root;
            if( null != root.left) {
                TreeInfo leftInfo = flattenBSTInfo(root.left);
                head = leftInfo.head;
                leftInfo.tail.right = root;
                root.left = leftInfo.tail;
            }
            if( null != root.right) {
                TreeInfo rightInfo = flattenBSTInfo(root.right);
                tail = rightInfo.tail;
                rightInfo.head.left = root;
                root.right = rightInfo.head;
            }
        }
        return new TreeInfo(head, tail);
    }


    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            if(null != node.prev) {
                System.out.print(node.prev.value + " ");
            }
            System.out.println(", ");
            node = node.next;
        }
    }

    void printList(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            if(null != node.left) {
                System.out.print(node.left.val + " ");
            }
            System.out.println(", ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        Tree2DoublyLinkedList solution = new Tree2DoublyLinkedList();
        TreeNode root = new TreeNode(10);

        // Let us create the tree shown in above diagram
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        // Convert to DLL
        TreeNode head = solution.flattenBST(root);

        solution.printList(head);
    }
}


