package wr.leetcode.algo.lowest_common_ancestor_of_a_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {



    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        LinkedList<TreeNode> lhs = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rhs = new LinkedList<TreeNode>();
        TreeNode ret = null;

        if(searchTreeNode(root, p, lhs) && searchTreeNode(root, q, rhs)) {
            ret = findIntersect(lhs, rhs);
        }
        return ret;
    }

    private TreeNode findIntersect(LinkedList<TreeNode> lhsIn, LinkedList<TreeNode> rhsIn) {
        TreeNode ret = null;

        ArrayList<TreeNode> lhs = new ArrayList<>(lhsIn);
        ArrayList<TreeNode> rhs = new ArrayList<>(rhsIn);
        int term = Math.min(lhs.size(), rhs.size());
        for (int i = 0; i < term; ++i) {
            if(lhs.get(i) != rhs.get(i)) {
                break;
            } else {
                ret = lhs.get(i);
            }
        }
        return ret;
    }


    public boolean searchTreeNode(TreeNode root, TreeNode key, LinkedList<TreeNode> path) {
        boolean ret = false;
        if(null == path) {
            path = new LinkedList<>();
        }

        if(null == root){
            if(null == key) {
                ret = true;
            }
        } else {
            path.addLast(root);
            if( (root.val == key.val) ||
                ((searchTreeNode(root.left, key, path) || searchTreeNode(root.right, key, path)))) {
                ret = true;
            } else {
                path.removeLast();
            }
        }
        return ret;
    }*/
   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        MetaData ret = lowestCommon(root, p, q, 0);
        return ret.found;
    }

    public MetaData lowestCommon(TreeNode root, TreeNode p, TreeNode q, int level) {

        MetaData ret = new MetaData();
        if (null == root){
            return ret;
        }

        MetaData leftRes = lowestCommon(root.left, p, q, level + 1);
        MetaData rightRes = lowestCommon(root.right, p, q, level+1);

        if( leftRes.isSolution() && rightRes.isSolution() ) {
            return (leftRes.level > rightRes.level) ? (leftRes):(rightRes);
        }
        if(leftRes.isSolution()) {
            return leftRes;
        }
        if(rightRes.isSolution()) {
            return rightRes;
        }

        ret.containsLeft = leftRes.containsLeft || rightRes.containsLeft || root.val == p.val;
        ret.containsRight = leftRes.containsRight || rightRes.containsRight || root.val == q.val;
        if(ret.containsLeft && ret.containsRight) {
            ret.found = root;
            ret.level = level;
        }
        return ret;
    }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(null == root) {
            return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }

        return (left != null)?(left):(right);
    }

}

class MetaData{
    boolean containsLeft = false;
    boolean containsRight = false;
    TreeNode found = null;
    Integer level = null;

    public boolean isSolution() {
        return this.containsLeft && this.containsRight;
    }
    /**
     * need to ask if the node requested was actually in the tree
     * compare is by reference or by value
     */


}