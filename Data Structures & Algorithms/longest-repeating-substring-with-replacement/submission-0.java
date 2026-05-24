class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int windowMaxFreq = 0;
        int maxLen = 0;

        int left = 0;
        int right = left;

        while (right < s.length()) {
            char ch = s.charAt(right);
            int curCharFreq = freqMap.getOrDefault(ch, 0) + 1;
            freqMap.put(ch, curCharFreq);

            windowMaxFreq = Math.max(curCharFreq, windowMaxFreq);

            if (windowMaxFreq + k >= right - left + 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                char leftCh = s.charAt(left);
                int leftFreq = freqMap.get(leftCh) - 1;
                freqMap.put(leftCh, leftFreq);
                windowMaxFreq = Math.max(curCharFreq, leftFreq);
                left ++;
            }
            right ++;
        }
        return maxLen;
    }
}
