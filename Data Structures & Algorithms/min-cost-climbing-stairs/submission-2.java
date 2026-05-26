class Solution {

    public int minCostClimbingStairs(int[] cost) {

        Integer[] dp = new Integer[cost.length + 1];

        int x= dfs(cost, -1, dp);
        return x;
    }

    public int dfs(int[] cost, int start, Integer[] dp) {

        if (start >= cost.length) {
            return 0;
        }

        if (dp[start + 1] != null) {
            return dp[start + 1];
        }
        
        int curCost = 0;
        if (start != -1) {
            curCost = cost[start];
        }

        dp[start + 1] = curCost + Math.min(
                dfs(cost, start + 1, dp),
                dfs(cost, start + 2, dp));

        return dp[start + 1];
    }
}
