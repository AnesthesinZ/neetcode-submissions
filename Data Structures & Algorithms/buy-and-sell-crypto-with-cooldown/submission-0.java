class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int buy = 1; buy <= n; buy++) {
            for (int sell = 1; sell <= n; sell++) {

                if (buy > sell) {
                    continue;
                }

                if (prices[buy-1] < prices[sell-1]) {

                    int price = prices[sell-1] - prices[buy-1];
                    if (buy >= 2) {
                        price += dp[buy-2][buy-2];
                    }

                    dp[buy][sell] =
                            Math.max(
                                    dp[buy-1][sell],
                                    price
                            );
                } else {
                    dp[buy][sell] = Math.max(dp[buy][sell-1], dp[buy-1][sell]);
                }
            }
        }

        return dp[n][n];
    }
}
