class Solution:
    def numIslands(self, grid):
        rows, cols = len(grid), len(grid[0])
        islands = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    self.bfs(grid, r, c)
                    islands += 1

        return islands

    def bfs(self, grid, r, c):
        rows, cols = len(grid), len(grid[0])
        queue = deque([(r, c)])
        grid[r][c] = '0'  # mark visited

        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        while queue:
            row, col = queue.popleft()

            for dr, dc in directions:
                nr, nc = row + dr, col + dc

                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == '1':
                    grid[nr][nc] = '0'
                    queue.append((nr, nc))