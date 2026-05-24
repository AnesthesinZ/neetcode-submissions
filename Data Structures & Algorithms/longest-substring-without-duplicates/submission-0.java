class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = left;

        Map<Character, Integer> charLoc = new HashMap<>();
        int maxChain = 0;

        while (right < s.length()) {
            if (charLoc.containsKey(s.charAt(right))) {
                maxChain = Math.max(maxChain, right - left);
                left = Math.max(left, charLoc.get(s.charAt(right)) + 1);
            } 
        
            charLoc.put(s.charAt(right), right);
            right ++;
        }

        maxChain = Math.max(maxChain, right - left);

        return maxChain;
    }
}
