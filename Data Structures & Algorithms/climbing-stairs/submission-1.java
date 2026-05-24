class Solution {
    public int climbStairs(int n) {

        int dpL = n < 3 ? 3 : n;

        int[] dp = new int[dpL + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
