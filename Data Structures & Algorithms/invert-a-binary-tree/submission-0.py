# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
       # traversal algorithm here is: bredth first 
       # we want to change the swap the right and left childs
       # O(n) => Time
       # O(n) => Space
       # solve it recursively DFS

       # base condition
       if root is None: return None

       tmp: Optional[TreeNode] = root.left
       root.left = root.right
       root.right = tmp

       self.invertTree(root.left)
       self.invertTree(root.right)

       return root