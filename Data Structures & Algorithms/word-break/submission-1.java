class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        if (n == 0) {
            return false;
        }

        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {

                int startCheckIdx = i + 1 - word.length();

                if (startCheckIdx >= 0 && s.startsWith(word, startCheckIdx)) {
                    if (startCheckIdx > 0) {
                        dp[i] = (true && dp[startCheckIdx - 1]);
                    } else {
                        dp[i] = true;
                    }
                    if (dp[i]) {
                        break;
                    }
                } else {
                    dp[i] = false;
                }
            }
        }

        return dp[n-1];
    }
}
