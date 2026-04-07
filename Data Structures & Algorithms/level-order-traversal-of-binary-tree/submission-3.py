# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # o(n) time and o(n) for space
        if not root: return [] 
        queue = deque()
        queue.appendleft(root)
        res = []

        while len(queue):
            level: int = len(queue)
            level_nodes = []

            for _ in range(0, level):
                node = queue.popleft()
                level_nodes.append(node.val)

                if node.left: 
                    queue.append(node.left)
                if node.right: 
                    queue.append(node.right)
            
            res.append(level_nodes)
        return res