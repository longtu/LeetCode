package wr.leetcode.algo.binary_tree_vertical_order_traversal;

import wr.leetcode.algo.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
/*
    public List<List<Integer>> verticalOrder(TreeNode root) {
        PriorityQueue<Data> queue = new PriorityQueue<>(this::compare);
        inOrder(root, queue, 0, 0);
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();
        Integer currentW = null;
        while(!queue.isEmpty()) {
            Data data = queue.poll();
            int w = data.w;
            if(null == currentW ) {
                currentW = w;
            } else if( !currentW.equals(w)){
                //BUG: update currentW
                currentW = w;
                ret.add(currentList);
                currentList = new LinkedList<>();
            }
            currentList.add(data.node.val);
        }
        if(!currentList.isEmpty()) {
            ret.add(currentList);
        }
        return ret;
    }

    public void inOrder( TreeNode node, PriorityQueue<Data> heap , int w, int h) {
        if (null == node) {
            return;
        }
        if( null != node.left ) {
            inOrder(node.left, heap, w-1, h+1);
        }
        heap.offer(new Data(w,h,node, heap.size()));

        if( null != node.right ) {
            inOrder(node.right, heap, w+1, h+1);
        }

    }

    class Data {
        int w;
        int h;
        int sequence;
        TreeNode node;

        public Data (int w, int h, TreeNode node, int sequence) {
            this.w = w;
            this.h = h;
            this.node = node;
            this.sequence = sequence;
        }
    }


    public int compare(Data left, Data right) {
        int diff;
        if(left.w != right.w) {
            diff = left.w - right.w;
        } else if(left.h != right.h){
            diff = left.h - right.h;
        } else {
            diff = left.sequence - right.sequence;
        }
        return diff;
    }*/
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> xqueue = new LinkedList<>();
        int x = 0;
        int min = 0;
        int max = 0;

        if (null != root) {
            nodes.offer(root);
            xqueue.offer(x);
        }
        while( !nodes.isEmpty() ) {
            TreeNode v = nodes.poll();
            int vx = xqueue.poll();
            List<Integer> list = map.getOrDefault(vx, new LinkedList<>());
            list.add(v.val);
            map.put(vx, list);
            max = Math.max(max, vx);
            min = Math.min(min, vx);

            if(null != v.left) {
                nodes.offer(v.left);
                xqueue.offer(vx-1);
            }
            if(null != v.right) {
                nodes.offer(v.right);
                xqueue.offer(vx+1);
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = min; i <=max; ++i) {
            List<Integer> list = map.get(i);
            if(null != list) {
                ret.add(list);
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