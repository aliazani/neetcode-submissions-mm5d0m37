"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        # O(V + E) time
        # O(E) space

        # recusrion -> visited(1) + where we can go from 1
        # do the same for children
        old_to_new: dict[Node, Node] = {}


        def dfs(node: Node) -> Node:
            if node in old_to_new: return old_to_new[node]

            copy: Node = Node(node.val)
            old_to_new[node] = copy
            for n in node.neighbors:
                copy.neighbors.append(dfs(n))
            

            return copy

        return dfs(node) if node else None
        