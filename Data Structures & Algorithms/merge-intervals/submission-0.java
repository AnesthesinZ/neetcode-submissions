class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        int[] prevInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prevInterval[1] < intervals[i][0]) {
                result.add(prevInterval);
                prevInterval = intervals[i];
            } else {
                prevInterval[0] = Math.min(prevInterval[0], intervals[i][0]);
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);
            }
        }

        result.add(prevInterval);

        return result.toArray(new int[result.size()][]);

    }
}
