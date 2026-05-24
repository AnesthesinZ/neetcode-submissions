class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (n <= 1) {
            return n;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            // think of each char or char + 1 is the center of the palindrome

            int left = i;
            int right = i;

            while (left >= 0 && right < n) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                }else {
                    break;
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                }else {
                    break;
                }
                left--;
                right++;
            }
        }

        return count;
    }
}
