class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1] == 1)
            return 0;

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for (int col = n-2; col >= 0; col--) {
            dp[m-1][col] = (obstacleGrid[m-1][col] == 0) ? dp[m-1][col+1] : 0;
        }

        for (int row = m-2; row >= 0; row--) {
            dp[row][n-1] = (obstacleGrid[row][n-1] == 0) ? dp[row+1][n-1] : 0;
        }

        for (int row = m-2; row >= 0; row--) {
            for (int col = n-2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 0) {
                    dp[row][col] = dp[row+1][col] + dp[row][col+1];
                }
            }
        }

        return dp[0][0];
    }
}