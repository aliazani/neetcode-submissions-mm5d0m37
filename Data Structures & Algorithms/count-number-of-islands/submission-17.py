class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        visited: Set[Tuple[int, int]] = set()
        islands = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and (r, c) not in visited:
                    self.bfs(grid, r, c, visited)
                    islands += 1

        return islands

    def bfs(self, grid, start_r, start_c, visited):
        rows, cols = len(grid), len(grid[0])
        queue = deque([(start_r, start_c)])
        visited.add((start_r, start_c))

        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        while queue:
            r, c = queue.popleft()

            for dr, dc in directions:
                nr, nc = r + dr, c + dc

                if (0 <= nr < rows and
                    0 <= nc < cols and
                    grid[nr][nc] == '1' and
                    (nr, nc) not in visited):

                    visited.add((nr, nc))
                    queue.append((nr, nc))