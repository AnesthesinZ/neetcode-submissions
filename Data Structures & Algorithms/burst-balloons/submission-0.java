class Solution {

    // for sub problems: think about blust a ballon, the range split into left and right two parts.
    // for each sub problem, since it's recursion, it's behaving like the last ballon, so always take the 
    // left and right boundary to calculate value.

    public int maxCoins(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1, dp);
    }

    public int dfs(int[] nums, int left, int right, Integer[][] dp) {
        if (right < left) {
            return 0;
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int max = 0;
        for (int i = left; i <= right; i++) {

            int leftValue = 1;
            if (left > 0) {
                leftValue = nums[left - 1];
            }

            int rightValue = 1;
            if (right < nums.length - 1) {
                rightValue = nums[right + 1];
            }

            int coins = nums[i] * leftValue * rightValue;
            max = Math.max(max, dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp) + coins);
        }

        dp[left][right] = max;
        return max;
    }
}
