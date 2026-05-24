class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        int[] charFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a'] ++;
            charFreq[t.charAt(i) - 'a'] --;
        }

        for (int freq : charFreq) {
            if (freq != 0) {
                return false;
            }
        }

        return true;

    }
}
