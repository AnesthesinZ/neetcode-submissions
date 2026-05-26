class Solution {

    public record Key(int i, boolean canBuy) {}

    public int maxProfit(int[] prices) {
        Map<Key, Integer> dp = new HashMap<>();

        return dfs(prices, 0, true, dp);
    }

    public int dfs(int[] prices, int i, boolean canBuy, Map<Key, Integer> dp) {

        if (i >= prices.length) {
            return 0;
        }

        Key key = new Key(i, canBuy);

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // hold is an option for both buy and sell
        int profit = dfs(prices, i + 1, canBuy, dp);

        if (canBuy) {
            // buy
            int buyProfit = dfs(prices, i + 1, !canBuy, dp) - prices[i];
            dp.put(key, Math.max(profit, buyProfit));
        } else {
            // sell
            int sellProfit = dfs(prices, i + 2, !canBuy, dp) + prices[i];
            dp.put(key, Math.max(profit, sellProfit));
        }

        return dp.get(key);

    }
}
