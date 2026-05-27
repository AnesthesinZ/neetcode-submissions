class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return dfs(word1, word2, 0, 0, dp);
    }

    public int dfs(String source, String target, int sourceIdx, int targetIdx, Integer[][] dp) {
        // if we reach the end of source, that means all remaining target need to be added.
        // if we reach the end of target, that means all remaining source need to be deleted.
        if (sourceIdx == source.length()) {
            return target.length() - targetIdx;
        }

        if (targetIdx == target.length()) {
            return source.length() - sourceIdx;
        }

        if(dp[sourceIdx][targetIdx] != null) {
            return dp[sourceIdx][targetIdx];
        }

        int min = Integer.MAX_VALUE;
        if (source.charAt(sourceIdx) == target.charAt(targetIdx)) {
            min = Math.min(min,
                dfs(source, target, sourceIdx + 1, targetIdx + 1, dp));
        }
        // insert the same char as the target
        min = Math.min(min,
            dfs(source, target, sourceIdx, targetIdx + 1, dp) + 1);

        // delete a char
        min = Math.min(
            min, dfs(source, target, sourceIdx + 1, targetIdx, dp) + 1);
        

        // replace a char
        min = Math.min(min,
            dfs(source, target, sourceIdx + 1, targetIdx + 1, dp) + 1);

        dp[sourceIdx][targetIdx] = min;

        return min;
    }
}
