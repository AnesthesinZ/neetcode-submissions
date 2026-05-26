class Solution {
    public boolean canPartition(int[] nums) {

        // think like: can i reach target value at index i? 
        // where i includes all previous values
        // to reuse:
            // if previous i can reach target value, then it's true
        // or 
        // if i - 1 can reach to (target - current value)
        // need to exclude the number itself since it will only be picked once.
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum / 2;
        boolean even = (sum % 2 == 0);

        if (!even) {
            return false;
        }

        Boolean[][] dp = new Boolean[target + 1][nums.length + 1];

        return dfs(nums, target, 0, dp);

    }

    public boolean dfs(int[] nums, int target, int i, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (target < 0 || i >= nums.length) {
            return false;
        }

        if (dp[target][i] != null) {
            return dp[target][i];
        }

        boolean found = 
            dfs(nums, target, i + 1, dp) || 
            dfs(nums, target - nums[i], i + 1, dp);


        dp[target][i] = found;
        return found;
    }
}
