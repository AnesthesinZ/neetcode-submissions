class Solution {

    List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, new ArrayList<>(), 0);
        return results;
    }

    public void backtrack(String s, List<String> subset, int startIdx) {

        if (startIdx == s.length()) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int len = 1; len <= s.length() - startIdx; len++) {
            int subEnd = Math.min(s.length(), startIdx + len);
            String sub = s.substring(startIdx, subEnd);
            if (isPalindrome(sub)) {
                subset.add(sub);
                backtrack(s, subset, startIdx + len);
                subset.remove(subset.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        if (s.length() > 0) {
            int l = 0;
            int r = s.length() - 1;

            while (l <= r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }

            return true;
        }
        return false;
    }
}
