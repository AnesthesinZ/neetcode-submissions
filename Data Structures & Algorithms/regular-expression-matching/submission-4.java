class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        boolean res = dfs(s, p, 0, 0, dp);
        return res;
    }

    public boolean dfs(String s, String p, int stringIdx, int patternIdx, Boolean[][] dp) {

        if (stringIdx == s.length() && patternIdx == p.length()) {
            return true;
        }

        if (patternIdx >= p.length()) {
            return false;
        }

        if (dp[stringIdx][patternIdx] != null) {
            return dp[stringIdx][patternIdx];
        }

        char patternCh = p.charAt(patternIdx);

        boolean match = false;
        if (patternIdx + 1 < p.length() && p.charAt(patternIdx + 1) == '*'){
            match = dfs(s, p, stringIdx, patternIdx + 2, dp);
        }
        
        if (patternCh == '*') {
            match = match || dfs(s, p, stringIdx, patternIdx + 1, dp); // match 0
            match = match || dfs(s, p, stringIdx, patternIdx - 1, dp); // match n previous ch
        } else if (stringIdx < s.length()) {
            char ch = s.charAt(stringIdx);
            if (patternCh == '.' || ch == patternCh) {
                match = match || dfs(s, p, stringIdx + 1, patternIdx + 1, dp);
            }
        } 
        dp[stringIdx][patternIdx] = match;
        return match;
    }
}
