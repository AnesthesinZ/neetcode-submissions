class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int base = 1;
        int base2 = 1;
        int res = base;

        for (int i = n - 2; i >= 0; i--) {
            res = base + base2;
            base = base2;
            base2 = res;
        }
        return res;
    }
}
