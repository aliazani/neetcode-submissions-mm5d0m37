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
        if not root:
            return None

        queue = deque([root])

        while queue:
            node = queue.popleft()

            # swap
            node.left, node.right = node.right, node.left

            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        return root
