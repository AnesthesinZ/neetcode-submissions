class Solution {
    public int numDecodings(String s) {
        // way of thought
        // think about decode 123
        // we take 1, the sub problem become decode(23)
        // we take 12, the sub problem become decode(3)
        // decode(123) = decode(23) + decode(3)

        // if 101
        // take 1, decode(01)
        // take 10, decode(1)

        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >=0; i--) {

            int cur = s.charAt(i) - '0';

            if (cur == 0) {
                dp[i] = 0;
            } else {

                dp[i] = dp[i+1];

                if (i + 1 < n) {
                    int next = s.charAt(i + 1) - '0';
                    if (cur == 1 || (cur == 2 && next <= 6)) {
                        dp[i] = dp[i] + dp[i+2];
                    }
                }
            } 
        }

        return dp[0];
    }
}
