class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Extra variable for first column
        // (since matrix[0][0] is shared between row0 and col0)
        boolean col0 = true;

        // ── STEP 1: Scan and use first row/col as flags ──
        for (int i = 0; i < rows; i++) {
            // Check if first column needs zeroing
            if (matrix[i][0] == 0) col0 = false;

            // Check rest of columns
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // flag the row
                    matrix[0][j] = 0;  // flag the column
                }
            }
        }

        // ── STEP 2: Zero inner cells (bottom-right block) ──
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // ── STEP 3: Zero first row if matrix[0][0] == 0 ──
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // ── STEP 4: Zero first column if col0 is false ──
        if (!col0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}