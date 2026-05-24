class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                // right side is increasing
                // and target greater than right side, so take left
                if (nums[right] >= nums[mid] && target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // left side is increasing
                // and target smaller than left side, so take right
                if (nums[left] <= nums[mid] && target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
