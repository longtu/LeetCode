# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root):
    	if root is None:
    		return True

    	return self.isValidBSTRange(root.left, None, root.val) and self.isValidBSTRange(root.right, root.val, None)

    def isValidBSTRange(self, root, min, max):
    	if root is None:
    		return True

    	return ( (min is None or min < root.val) and self.isValidBSTRange(root.left, min, root.val)) ) and ((max is None) or (max > root.val and self.isValidBSTRange(root.right, root.val, max)))

