class Solution {
    public String longestPalindrome(String s) {
        // expand from center appoarch, treate every char or every two chars
        // as the center of the palindrome
        // expand the window by one char each time.

        // dp appoarch
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int[] pair = new int[]{0, 0};
        int len = 1;

        for (int to = 1; to < n; to++) {
            for (int from = 0; from < to; from++) {
                char firstCh = s.charAt(from);
                char lastCh = s.charAt(to);

                if (from + 1 <= to - 1) {
                    dp[from][to] = dp[from+1][to-1] && (firstCh == lastCh);
                } else {
                    dp[from][to] = (firstCh == lastCh);
                }

                if (dp[from][to]) {
                    if (len < to - from + 1) {
                        len = to - from + 1;
                        pair[0] = from;
                        pair[1] = to;
                    }
                }

            }
        }

        return s.substring(pair[0], pair[1] + 1);
    }
}
