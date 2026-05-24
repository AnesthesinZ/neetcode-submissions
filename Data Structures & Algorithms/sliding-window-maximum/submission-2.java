class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // monotonically decreasing deque
        // if later value is greater than what's in the deque, pop them.
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        // build the window first
        for (int i = 0; i < k; i++) {
            while (deque.peekLast() != null && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.add(nums[i]);
        }
        res.add(deque.peekFirst());

        int l = 0;
        int r = k - 1;

        while (r < nums.length - 1) {
            // drop the left first
            int leftToDrop = nums[l];
            if (leftToDrop == deque.getFirst()) {
                deque.pollFirst();
            }

            int rightToAdd = nums[r+1];
            while (deque.peekLast() != null && deque.peekLast() < rightToAdd) {
                deque.pollLast();
            }
            deque.add(rightToAdd);
            res.add(deque.peekFirst());
            r++;
            l++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
