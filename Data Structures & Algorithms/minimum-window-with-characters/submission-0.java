class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        int targetFreqMatch = targetFreq.size();
        int freqMatched = 0;

        int left = 0;
        int right = left;

        int[] res = new int[2];
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char curCh = s.charAt(right);
            int chFreq = windowFreq.getOrDefault(curCh, 0) + 1;
            windowFreq.put(curCh, chFreq);

            if (targetFreq.containsKey(curCh) && 
                targetFreq.get(curCh).equals(chFreq)) {
                freqMatched ++;
            }

            while (freqMatched == targetFreqMatch) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftCh = s.charAt(left);
                windowFreq.put(leftCh, windowFreq.getOrDefault(leftCh, 0) - 1);

                if (targetFreq.containsKey(leftCh) &&
                    targetFreq.get(leftCh) > windowFreq.get(leftCh)) {
                    freqMatched --;
                }
                left ++;
            }

            right ++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
