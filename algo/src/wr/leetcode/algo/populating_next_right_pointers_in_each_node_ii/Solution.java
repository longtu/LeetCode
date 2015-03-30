package wr.leetcode.algo.populating_next_right_pointers_in_each_node_ii;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class Solution {

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
}