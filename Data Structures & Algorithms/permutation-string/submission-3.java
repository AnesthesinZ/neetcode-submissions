class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            targetFreq[s1.charAt(i) - 'a'] ++;
            windowFreq[s2.charAt(i) - 'a'] ++;
        }

        int matches = 0;

        for (int i =0; i < 26; i++) {
            if (targetFreq[i] == windowFreq[i]) {
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

            if (windowFreq[rightCharIdx] == targetFreq[rightCharIdx]) {
                matches ++;
            } else if (windowFreq[rightCharIdx] - 1 == targetFreq[rightCharIdx]){
                matches --;
            }


            int leftCharIdx = s2.charAt(left) - 'a';
            windowFreq[leftCharIdx] --;

            if (windowFreq[leftCharIdx] == targetFreq[leftCharIdx]) {
                matches ++;
            } else if (windowFreq[leftCharIdx] + 1 == targetFreq[leftCharIdx]){
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
