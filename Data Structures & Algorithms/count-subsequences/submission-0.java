class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return dfs(s, t, 0, 0, 0, dp);
    }

    public int dfs(String s, String t, int sIndex, int tIndex, int validCount, Integer[][] dp) {
        
        if(validCount == t.length()) {
            return 1;
        }

        if (sIndex >= s.length() || tIndex >= t.length()) {
            return 0;
        }

        if (dp[sIndex][tIndex] != null) {
            return dp[sIndex][tIndex];
        }

        int ways = 0;

        // take the character if match or not take
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            ways += dfs(s, t, sIndex+1, tIndex+1, validCount+1, dp);
        }
        ways+= dfs(s, t, sIndex+1, tIndex, validCount, dp);
        dp[sIndex][tIndex] = ways;
        return ways;
    }
}
