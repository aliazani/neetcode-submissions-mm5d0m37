class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parent: list[int] = [i for i in range(n)]
        rank: list[int] = [1] * n


        def find(node: int) -> int:
            res: int = node

            while res != parent[res]:
                parent[res] = parent[parent[res]]
                res = parent[res]
            
            return res


        def union(node1: int, node2: int) -> int:
            p1:int = find(node1)
            p2:int = find(node2)

            if p1 == p2: return 0
            elif rank[p1] > rank[p2]:
                parent[p2] = p1
                rank[p1] += 1
            else: 
                parent[p1] = p2
                rank[p2] += 1
            return 1
        res: int = n
        for n1, n2 in edges:
            res -= union(n1, n2)
        
        return res