class Solution {
    public int coinChange(int[] coins, int amount) {
        // think about it this way
        // e.g. coin 2,3,4,5 target 7
        // when calculating amount for 6, we iterate through coins
        // the count are calculated by 
        // count(2) + count(6-2)
        // count(3) + count(6-3)
        // count(4) + count(6-4)
        // count(5) + count(6-5)
        // all of those should be calcuated already if we group from 1 to 6
        Integer[] dp = new Integer[amount + 1];
        return dfs(coins, amount, dp);
        
    }

    public int dfs(int[] coins, int amount, Integer[] dp) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != null) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        boolean invalid = true;

        for (int coin: coins) {
            int count = dfs(coins, amount - coin, dp);
            if (count != -1) {
                invalid = false;
                min = Math.min(min, 1 + count);
            }
        }

        if (invalid) {
            dp[amount] = -1;
            return -1;
        }

        dp[amount] = min;

        return min;
    }
}
