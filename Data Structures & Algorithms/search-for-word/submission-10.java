class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] path = new boolean[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c =0; c < cols; c++) {
                if (dfs(board, word, r, c, 0, path)) return true;
            }
        }
        return false;

    }
    private boolean dfs(char[][] board, String word, int row, int column, int i, boolean[][] path) {
        if (i == word.length()) return true;

        else if (row < 0 || column < 0 || row >= board.length || column >= board[0].length ||
                board[row][column] != word.charAt(i) ||
                path[row][column]) return false;

        path[row][column] = true;

        boolean found =
                dfs(board, word, row + 1, column, i + 1, path) ||
                dfs(board, word, row - 1, column, i + 1, path) ||
                dfs(board, word, row, column + 1, i + 1, path) ||
                dfs(board, word, row, column - 1, i + 1, path);

        path[row][column] = false;

        return found;
    }
}
