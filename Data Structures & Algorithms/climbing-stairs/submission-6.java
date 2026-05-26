class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return dfs(n, dp);
    }

    public int dfs(int target, int[] dp) {
        if (target < 0) {
            return 0;
        }

        if (dp[target] != 0) {
            return dp[target];
        }

        if (target == 0) {
            return 1;
        }

        dp[target] = dfs(target - 1, dp) + dfs(target - 2, dp);

        return dp[target];
    }
}
