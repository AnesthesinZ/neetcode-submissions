class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a'] ++;
            windowFreq[s2.charAt(i) - 'a'] ++;
        }

        int matches = 0;

        for (int i =0; i < 26; i++) {
            if (s1Freq[i] == windowFreq[i]) {
                matches ++;
            }
        }

        if (matches == 26) {
            return true;
        }

        int left = 0;
        int right = s1.length();

        while (right < s2.length()) {

            int rightCharIdx = s2.charAt(right) - 'a';
            windowFreq[rightCharIdx]++;

            if (windowFreq[rightCharIdx] == s1Freq[rightCharIdx]) {
                matches ++;
            } else if (windowFreq[rightCharIdx] - 1 == s1Freq[rightCharIdx]){
                matches --;
            }

            
            int leftCharIdx = s2.charAt(left) - 'a';
            windowFreq[leftCharIdx] --;

            if (windowFreq[leftCharIdx] == s1Freq[leftCharIdx]) {
                matches ++;
            } else if (windowFreq[leftCharIdx] + 1 == s1Freq[leftCharIdx]){
                matches --;
            }

            if (matches == 26) {
                return true;
            }

            left++;
            right++;
        }

        return matches == 26;
    }
}
