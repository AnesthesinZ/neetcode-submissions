class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num: nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }

        freqMap.forEach((num, freq)-> {
            buckets[freq].add(num);
        });

        int topIdx = 0;
        for (int i = buckets.length - 1; i >= 0 && topIdx < k; i--) {
            if (!buckets[i].isEmpty()) {
                for (int n : buckets[i]) {
                    result[topIdx] = n;
                    topIdx++;
                    if (topIdx == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
