class Solution {
    public int maxGold(int[][] mat) {
        // code here
         int n = mat.length;      
        int m = mat[0].length;   

        int[][] dp = new int[n][m];

       
        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int right = (col == m - 1) ? 0 : dp[row][col + 1];
                int rightUp = (row == 0 || col == m - 1) ? 0 : dp[row - 1][col + 1];
                int rightDown = (row == n - 1 || col == m - 1) ? 0 : dp[row + 1][col + 1];

                dp[row][col] = mat[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

       
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
}