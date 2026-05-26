class Solution {
    public int rob(int[] nums) {

        Integer[] dp = new Integer[nums.length];

        return dfs(nums, 0, dp);
    }

    public int dfs(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        dp[i] = Math.max(nums[i] + dfs(nums, i + 2, dp), dfs(nums, i + 1, dp));

        return dp[i];
    }
}
