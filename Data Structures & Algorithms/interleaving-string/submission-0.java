class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int targetLen = s3.length();

        Boolean dp[][] = new Boolean[s1Len + 1][s2Len + 1];

        if (s1Len + s2Len != targetLen) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0, 0, dp);
    }

    public boolean dfs(String s1, String s2, String s3, 
                       int s1Index, int s2Index, int i, Boolean dp[][]) {
        if (s1Index == s1.length() && s2Index == s2.length() && i == s3.length()) {
            return true;
        }

        if (i >= s3.length()) {
            return false;
        }

        if (dp[s1Index][s2Index] != null) {
            return dp[s1Index][s2Index];
        }

        // take from s1, if match with char in s3, if not match, return false;
        // or take from s2, if match with char in s3, if not match, return false;
        boolean res = false;
        if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(i)) {
            res = dfs(s1, s2, s3, s1Index + 1, s2Index, i + 1, dp);
        }
        if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(i)) {
            res = res || dfs(s1, s2, s3, s1Index, s2Index + 1, i + 1, dp);
        }

        dp[s1Index][s2Index] = res;
        return res;
    }
}
