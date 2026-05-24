class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxWater = 0;

        while (left < right) {

            int heightL = heights[left];
            int heightR = heights[right];

            maxWater = Math.max(maxWater, 
                Math.min(heightL, heightR) * (right - left));

            if (heightL < heightR) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}