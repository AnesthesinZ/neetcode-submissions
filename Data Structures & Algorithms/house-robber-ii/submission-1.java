class Solution {
    public int rob(int[] nums) {

        if (nums.length <= 1) {
            return nums[0];
        }

        return Math.max(
            rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1)
        );
    }

    public int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n <= 1) {
            return nums[start];
        }

        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[start+i] + dp[i-2], dp[i-1]);
        }
        return dp[end - start];
    }
}
