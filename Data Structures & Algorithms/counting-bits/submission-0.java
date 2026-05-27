class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            int count = 0;
            int target = i;
            while (target != 0) {
                count += ((target & 1) == 1 ? 1 : 0);
                target = target >> 1;
            }

            res[i] = count;
        }

        return res;
    }
}
