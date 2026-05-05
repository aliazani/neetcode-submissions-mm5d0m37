class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length()+1;
        int col = text2.length()+1;
        int[][] dp = new int[row][col];
        // init of dp
        for(int i=0;i<row;i++) 
            for (int j=0; j<col; j++)
                dp[i][j] =0;

        for (int i=row-2;i>=0;i--) {
            for (int j=col-2;j>=0;j--) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }

        return dp[0][0];
    }
}
