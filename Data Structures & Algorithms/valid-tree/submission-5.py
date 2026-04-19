class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj: dict[int, List[int]] = {i: [] for i in range(n)}
        visited: set[int] = set()

        # Build undirected graph
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)

        # DFS to detect cycle
        def dfs(node: int, parent: int) -> bool:
            if node in visited:
                return False

            visited.add(node)

            for nei in adj[node]:
                if nei == parent:
                    continue
                if not dfs(nei, node):
                    return False

            return True

        # Must have no cycle AND all nodes connected
        return dfs(0, -1) and len(visited) == n