class Solution {
    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> seqMap = new HashMap<>();
        int maxSeq = 0;
        
        // just need to update the boundary of the sequence, since duplicate num won't need to calculate the path length;
        for (int i : nums) {
            if (!seqMap.containsKey(i)) {
                // if not existing before, len(i - 1) + len(i + 1) + 1
                int seqLength = seqMap.getOrDefault(i - 1, 0) + seqMap.getOrDefault(i + 1, 0) + 1;
                seqMap.put(i, seqLength);

                // update the left bound, num - len(i - 1)
                seqMap.put(i - seqMap.getOrDefault(i - 1, 0), seqLength);

                // update the right bound, num + len(i + 1)
                seqMap.put(i + seqMap.getOrDefault(i + 1, 0), seqLength);

                maxSeq = Math.max(maxSeq, seqLength);

            }
        }

        return maxSeq;
    }
}
