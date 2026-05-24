class Solution {
    public int trap(int[] height) {
        int maxWater = 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeftHeight = 0;
        int maxRightHeight = 0;

        // base case: on i, the water it could trap is 
        // min(maxLeftHeight, maxRightHeight) - curHeight

        while (left < right) {

            int leftHeight = height[left];
            int rightHeight = height[right];

            if (leftHeight < rightHeight) {
                maxLeftHeight = Math.max(maxLeftHeight, leftHeight);
                maxWater = maxWater + maxLeftHeight - height[left];
                left++;
            } else {
                maxRightHeight = Math.max(maxRightHeight, rightHeight);
                maxWater = maxWater + maxRightHeight - height[right];
                right--;
            }
        }

        return maxWater;
    }
}
