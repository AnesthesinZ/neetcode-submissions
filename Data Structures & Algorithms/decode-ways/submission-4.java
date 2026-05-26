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

        Integer[] dp = new Integer[s.length() + 1];
        dp[s.length()] = 1;
        return dfs(s, 0, dp);
    }

    public int dfs(String s, int start, Integer[] dp) {
        if (dp[start] != null) {
            return dp[start];
        }

        char cur = s.charAt(start);

        if (cur == '0') {
            return 0;
        }

        int ways = dfs(s, start + 1, dp);

        if (start + 1 < s.length()) {
            char next = s.charAt(start + 1);

            if (cur == '1' || (cur == '2' && next < '7')) {
                ways += dfs(s, start + 2, dp);
            }
        }

        dp[start] = ways;

        return ways;
    }
}
