class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];

        while (left < right) {
            int leftN = numbers[left];
            int rightN = numbers[right];

            int sum = leftN + rightN;

            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
