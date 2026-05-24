class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // small first, large second
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int topLen = nums1.length;
        int botLen = nums2.length;

        int left = 0;
        int right = topLen;

        boolean even = ((topLen + botLen) % 2) == 0;

        while (left <= right) {
            int topPivot = (left + right) / 2;
            int botPivot = (topLen + botLen + 1) / 2 - topPivot;

            int topLeft = topPivot == 0 ? Integer.MIN_VALUE : nums1[topPivot - 1];
            int topRight = topPivot == topLen ? Integer.MAX_VALUE : nums1[topPivot];

            int botLeft = botPivot == 0 ? Integer.MIN_VALUE : nums2[botPivot - 1];
            int botRight = botPivot == botLen ? Integer.MAX_VALUE : nums2[botPivot];

            if (topLeft <= botRight && topRight >= botLeft) {
                if (even) {
                    return (Math.max(topLeft, botLeft) + Math.min(topRight, botRight)) / 2.0;
                } else {
                    return Math.max(topLeft, botLeft);
                }
            } else if (topLeft > botRight) {
                right = topPivot - 1;
            } else {
                left = topPivot + 1;
            }
        }

        return 0.0;
    }
}
