class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount + 1;

        int[] dp = new int[n];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int coin: coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}