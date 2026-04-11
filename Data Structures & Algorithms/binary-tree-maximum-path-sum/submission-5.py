# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.res = float("-inf")
        self.dfs(root)
        return self.res
    
    def dfs(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0

        leftMax = max(self.dfs(node.left), 0)
        rightMax = max(self.dfs(node.right), 0)

        # path passing through this node
        self.res = max(self.res, node.val + leftMax + rightMax)

        # return best one-side path to parent
        return node.val + max(leftMax, rightMax)