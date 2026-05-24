class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

        while (left <= right) {
            int mid = (left + right) / 2;
            int days = daysToEatAll(piles, mid);

            if (days > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int daysToEatAll(int[] piles, int rate) {

        int days = 0;

        for (int pile : piles) {
            days += pile / rate;
            days += pile % rate > 0 ? 1 : 0;
        }

        return days;
    }
}
