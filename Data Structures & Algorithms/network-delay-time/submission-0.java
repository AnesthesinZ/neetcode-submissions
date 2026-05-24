class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        boolean[] processed = new boolean[n];

        // source -> [dest, time]
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            int source = time[0] - 1;
            int dest = time[1] - 1;
            int[] destInfo = new int[] {dest, time[2]};

            adjList.computeIfAbsent(source, v->new ArrayList<>()).add(destInfo);
        }

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k-1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(a[1], b[1]));
        pq.add(new int[] {k-1, 0});

        while (!pq.isEmpty()) {
            int[] sourceInfo = pq.poll();
            int source = sourceInfo[0];
            int baseDist = sourceInfo[1];

            if (!processed[source]) {
                for (int[] destInfo : adjList.getOrDefault(source, Collections.emptyList())) {
                    int dest = destInfo[0];
                    int timeToDest = destInfo[1];
                    dist[dest] = Math.min(dist[dest], baseDist + timeToDest);
                    pq.add(new int[] {dest, dist[dest]});
                }

                processed[source] = true;
            }
        }

        for (boolean pro : processed) {
            if (!pro) {
                return -1;
            }
        }

        int res = 0;
        for (int d : dist) {
            res = Math.max(res, d);
        }

        return res;
    }
}
