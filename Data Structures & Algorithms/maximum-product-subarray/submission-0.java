class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] products = new int[n][n];
        int max = Integer.MIN_VALUE;

        for (int from = 0; from < n; from++) { // from
            for (int to = from; to < n; to++) { // to
                if (from == to) {
                    products[from][to] = nums[from];
                } else {
                    products[from][to] = products[from][to - 1] * nums[to];
                }

                max = Math.max(products[from][to], max);
            }
        }
        return max;
    }
}
