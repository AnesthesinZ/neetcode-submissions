class Solution {
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                int diff = i - coin;
                if (diff == 0) {
                    dp[i] = 1;
                } else if (diff > 0) {
                    if (dp[coin] != 0 && dp[diff] != 0) {
                        if (dp[i] == 0 || (dp[i] > dp[coin] + dp[diff])) {
                            dp[i] = dp[coin] + dp[diff];
                        }
                    }
                }
            }
        }

        if (dp[amount] == 0) {
            return -1;
        }

        return dp[amount];
    }
}
