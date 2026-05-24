class Solution {
    public int maxProduct(int[] nums) {
        // track previous max and min at current number
        int prevMax = nums[0];
        int prevMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(Math.max(prevMax * nums[i], prevMin * nums[i]), nums[i]);
            int tempMin = Math.min(Math.min(prevMin * nums[i], prevMax * nums[i]), nums[i]);
            
            prevMax = tempMax;
            prevMin = tempMin;

            ans = Math.max(prevMax, ans);
        }

        return ans;
    }
}
