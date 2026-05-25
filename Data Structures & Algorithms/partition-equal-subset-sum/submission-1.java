class Solution {
    public boolean canPartition(int[] nums) {

        // think like: can i reach target value at index i? 
        // where i includes all previous values
        // to reuse:
            // if previous i can reach target value, then it's true
        // or 
        // if i - 1 can reach to (target - current value)
        
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int curTarget = 0; curTarget <= target; curTarget++) {
                if(curTarget == nums[i]) {
                    dp[i][curTarget] = true;
                } else {
                    if (i > 1) {
                        if (curTarget > nums[i]) {
                            dp[i][curTarget] = dp[i-1][curTarget - nums[i]] || 
                                dp[i-1][curTarget];
                        } else {
                            dp[i][curTarget] = dp[i-1][curTarget];
                        }
                    }
                }
            }
        }

        return dp[n-1][target];
    }
}
