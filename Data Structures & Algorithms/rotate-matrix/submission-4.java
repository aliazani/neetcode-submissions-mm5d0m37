class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (left <= right) {
            for (int i=0; i<(right-left); i++) {
                int top = left;
                int bottom = right;
                
                // top left
                int topLeft = matrix[top][left + i];

                // replace top left
                matrix[top][left+i] = matrix[bottom-i][left];

                // replace bottom left
                matrix[bottom-i][left] = matrix[bottom][right-i];

                // replace bottom right
                matrix[bottom][right-i] = matrix[top+i][right];

                // replace top right
                matrix[top+i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}
