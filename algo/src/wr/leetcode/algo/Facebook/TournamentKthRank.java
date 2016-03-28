package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

public class TournamentKthRank {

    TreeNode findKthRank(TreeNode root, int k) {
        if( k == 1) {
            return root;
        }
        int i = 1;
        while( (i <<1) < k) {
            i = i<<1;
        }
        int parent = k - i;
        TreeNode parentNode = findKthRank(root, parent);
        return (parentNode.left.val == parentNode.val)?(parentNode.right):(parentNode.left);

    }
}
