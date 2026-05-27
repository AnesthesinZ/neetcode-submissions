class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        boolean res = dfs(s, p, 0, 0, dp);
        return res;
    }

    public boolean dfs(String s, String p, int stringIdx, int patternIdx, Boolean[][] dp) {

        if (patternIdx == p.length()) {
            return stringIdx == s.length();
        }

        if (dp[stringIdx][patternIdx] != null) {
            return dp[stringIdx][patternIdx];
        }

        boolean match = false;

        boolean charMatch = stringIdx < s.length() && 
            (p.charAt(patternIdx) == '.' || 
            s.charAt(stringIdx) == p.charAt(patternIdx));


        if (patternIdx + 1 < p.length() && p.charAt(patternIdx + 1) == '*'){
            match = dfs(s, p, stringIdx, patternIdx + 2, dp) || // skip the .*
                (charMatch && dfs(s, p, stringIdx + 1, patternIdx, dp));   // match the .*
        } else {
            match = charMatch && dfs(s, p, stringIdx + 1, patternIdx + 1, dp);
        }
        
        dp[stringIdx][patternIdx] = match;
        return match;
    }
}
