package wr.leetcode.algo.binary_tree_vertical_order_traversal;

import wr.leetcode.algo.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Implementation with HashMap
     */
    public List<List<Integer>> verticalOrder0(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        Map<Integer, List<Integer>> nodeList = new HashMap<>();
        int leftMost = 0;

        Queue<Info> queue = new LinkedList<>();
        if( null != root ) {
            queue.offer(new Info(leftMost, root));
        }

        while( !queue.isEmpty() ) {
            Info v = queue.poll();
            List<Integer> list = nodeList.getOrDefault(v.width, new LinkedList<>());
            list.add(v.node.val);
            nodeList.put(v.width, list);
            leftMost = Math.min(leftMost, v.width);
            if(null != v.node.left) {
                queue.offer(new Info(v.width-1, v.node.left));
            }
            if(null != v.node.right) {
                queue.offer(new Info(v.width+1, v.node.right));
            }
        }

        for (int i = leftMost; nodeList.containsKey(i); ++i) {
            ret.add(nodeList.get(i));
        }
        return ret;
    }

    class Info {
        TreeNode node;
        int width;

        public Info (int width, TreeNode node) {
            this.width = width;
            this.node = node;
        }
    }

    /**
     * Implementation without HashMap
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        int min = 0;
        int max = 0;
        Queue<Info> queue = new LinkedList<>();
        if( null != root ) {
            queue.offer(new Info(min, root));
            ret.add(new LinkedList<>());
        }

        while( !queue.isEmpty() ) {
            Info v = queue.poll();
            TreeNode node = v.node;
            int w = v.width;
            if(w < min) {
                ret.add(0, new LinkedList<>());
                min = w;
            }
            if(w > max) {
                ret.add(new LinkedList<>());
                max = w;
            }
            int id = w - min;
            List<Integer> list = ret.get(id);
            list.add(node.val);
            if(null != v.node.left) {
                queue.offer(new Info(v.width-1, v.node.left));
            }
            if(null != v.node.right) {
                queue.offer(new Info(v.width+1, v.node.right));
            }
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);


        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;
        n9.left = n4;
        n9.right = n5;

        System.out.println(sol.verticalOrder(n3));

    }
}