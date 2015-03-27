# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        stack = [];
        ret = [];

        if root is None:
            return ret

        stack.append(root)
        count = 0
        while len(stack) > 0:
            count +=1
            top = stack[-1]
            if (top.right is None) and (top.left is None): #not right, right
                ret.append(stack.pop())
                print count, 'h1'
                continue
            elif len(ret) > 0 and( ret[-1] == top.left or ret[-1] == top.right):
                ret.append(stack.pop())
                print count, 'h2'
                continue
            else:
                if not top.right is None:
                    stack.append(top.right)
                if not top.left is None:
                    stack.append(top.left)
                print count, 'h3'
        ##otherwise difficult to compare ret and stack values
        return [ i.val for i  in ret]

if __name__ == '__main__':
    sol = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    print sol.postorderTraversal(root)