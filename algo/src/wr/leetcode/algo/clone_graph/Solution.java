package wr.leetcode.algo.clone_graph;

import wr.leetcode.algo.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null == node) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> copy = new HashMap();
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        copy.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode neighbour : n.neighbors) {
                if(!copy.containsKey(neighbour)) {
                    copy.put(neighbour, new UndirectedGraphNode(neighbour.label));
                    queue.offer(neighbour);
                }
                copy.get(n).neighbors.add(copy.get(neighbour));
            }
        }
        return copy.get(node);
    }
}
