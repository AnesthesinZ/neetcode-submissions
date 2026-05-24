class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;

            if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return -1;
    }
}
