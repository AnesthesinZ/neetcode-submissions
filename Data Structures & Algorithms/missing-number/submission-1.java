class Solution {
    public int missingNumber(int[] nums) {
        int mask = 0;
        for (int i = 0; i < nums.length; i++) {
            mask ^= i;
            mask ^= nums[i];
        }

        mask ^= nums.length;

        return mask;
    }
}
