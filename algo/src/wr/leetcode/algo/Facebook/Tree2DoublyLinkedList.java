package wr.leetcode.algo.Facebook;

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

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode( int value) {
        this.value = value;
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

public class Tree2DoublyLinkedList {

    ListNode tree2List(TreeNode root) {
        return tree2ListInfo(root).head;
    }

    Info tree2ListInfo( TreeNode root ) {
        Info info = new Info(null, null);
        if( null == root) {
            return info;
        }
        ListNode node = new ListNode(root.value);
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
        ListNode head = solution.tree2List(root);

        solution.printList(head);
    }
}


