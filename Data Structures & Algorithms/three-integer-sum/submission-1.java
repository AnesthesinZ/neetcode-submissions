class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int prevN = nums[i];
            int target = -prevN;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftN = nums[left];
                int rightN = nums[right];
                int sum = leftN + rightN;

                if (sum == target) {
                    results.add(List.of(prevN, leftN, rightN));
                    left ++;

                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left ++;
                    }

                    right --;
                    while (right >= 0 && nums[right] == nums[right + 1] ) {
                        right --;
                    }

                } else if (sum < target) {
                    left ++;
                } else if (sum > target) {
                    right --;
                }
            }

            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return results;
    }
}
