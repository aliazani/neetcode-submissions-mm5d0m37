# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    def serialize(self, root: Optional[TreeNode]) -> str:
        result = []

        def dfs(node):
            if node is None:
                result.append("N")
                return
            
            result.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return ",".join(result)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        values = data.split(",")
        index = 0

        def dfs():
            nonlocal index

            # Base case: null node
            if values[index] == "N":
                index += 1
                return None

            # Create node
            node = TreeNode(int(values[index]))
            index += 1

            # Build left and right subtrees
            node.left = dfs()
            node.right = dfs()

            return node

        return dfs()