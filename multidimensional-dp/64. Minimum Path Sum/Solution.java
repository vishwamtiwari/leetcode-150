class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        dp[n - 1] = grid[m - 1][n - 1];
        for (int col = n - 2; col >= 0; col--) {
            dp[col] = grid[m - 1][col] + dp[col + 1];
        }

        for (int row = m - 2; row >= 0; row--) {
            dp[n - 1] += grid[row][n - 1];
            for (int col = n - 2; col >= 0; col--) {
                dp[col] = grid[row][col] + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
}