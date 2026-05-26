class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[amount + 1][coins.length];
        return dfs(amount, coins, dp, 0);
    }

    public int dfs(int amount, int[] coins, Integer[][] dp, int begin) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        if (dp[amount][begin] != null) {
            return dp[amount][begin];
        }

        int times = 0;
        for (int i = begin; i < coins.length; i++) {
            times += dfs(amount - coins[i], coins, dp, i);
        }

        dp[amount][begin] = times;

        return times;
    }
}
