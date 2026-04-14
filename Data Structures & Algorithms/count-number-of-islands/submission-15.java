class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet();
        int res = 0;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    bfs(i, j, visited, rows, cols, grid); 
                    res++;
                }
            }
        }

        return res;
    }

    private void bfs(int r, int c, Set<String> visited, int rows, int cols, char[][] grid) {
        Queue<String> queue = new ArrayDeque();
        visited.add(r + "," + c);
        queue.add(r + "," + c);

        while(!queue.isEmpty()) {
            String popped = queue.poll();
            String[] parts = popped.split(",");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int dr = dir[0] + row; // row change
                int dc = dir[1] + col; // col change
                
                if (dc >= 0 && dc < cols &&
                    dr >= 0 && dr < rows &&
                    grid[dr][dc] == '1' && !visited.contains(dr + "," + dc)) {
                        visited.add(dr + ","+ dc);
                        queue.add(dr + ","+ dc);
                    }
            } 
        }

    }
}
