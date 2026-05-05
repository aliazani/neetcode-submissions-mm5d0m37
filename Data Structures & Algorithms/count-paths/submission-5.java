class Solution {
    public int uniquePaths(int m, int n) {
        int[] bottomRow = new int[n];
        for(int i=0; i < n; i++) bottomRow[i] = 1;


        for (int i=0;i<m-1;i++) {
            int[] currentRow = new int[n];
            for(int j=0; j < n; j++) currentRow[j] = 1;

            for(int k=n-2; k >= 0; k--) {
                currentRow[k] = currentRow[k+1] + bottomRow[k];
            }
            // moving upwards
            bottomRow = currentRow;
        }

        return bottomRow[0];
    }
}
