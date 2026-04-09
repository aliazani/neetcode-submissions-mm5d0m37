# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isValid(root, float('-inf'), float('inf'))

    def isValid(self, current: Optional[TreeNode], left: float, right: float) -> bool:

        if not current: return True

        elif current.val <= left or current.val >= right: return False

        # on the left side the upper bound will change
        # on the right side the lower bound will change
        return self.isValid(current.left, left, current.val) and \
               self.isValid(current.right, current.val, right) 
