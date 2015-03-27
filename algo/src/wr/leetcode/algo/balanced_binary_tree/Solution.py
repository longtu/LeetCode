
class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        return self.balanceTree(root)[0]


    def balanceTree(self, root):
        if root is None:
            balanced = True
            height = 0

        else:
            (lb, lh) = self.balanceTree(root.left)
            (rb, rh) = self.balanceTree(root.right)
            balanced = lb and rb and abs(lh-rh) < 2
            height = max(lh, rh) + 1
        
        return (balanced, height)
if __name__ == '__main__':
	sol = Solution()
	print sol.isBalanced(None)