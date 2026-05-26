class Solution {

    public record Key(int target, int idx) {};

    public int findTargetSumWays(int[] nums, int target) {
        Map<Key, Integer> dp = new HashMap<>();
        return dfs(nums, target, 0, dp);

    }

    public int dfs(int[] nums, int target, int i, Map<Key, Integer> dp) {
        if (i == nums.length && target == 0) {
            return 1;
        }

        if (i >= nums.length) {
            return 0;
        }

        Key key = new Key(target, i);

        if (dp.containsKey(key)){
            return dp.get(key);
        }

        int ways = dfs(nums, target + nums[i], i+1, dp) + 
            dfs(nums, target - nums[i], i+1, dp);

        dp.put(key, ways);

        return ways;
    }
}
