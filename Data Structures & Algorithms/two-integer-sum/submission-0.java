class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int pairValue = target - nums[i];

            if (pairMap.containsKey(nums[i])) {
                return new int[] { pairMap.get(nums[i]), i };
            } else {
                pairMap.put(pairValue, i);
            }

        }

        return new int[2];
    }
}
