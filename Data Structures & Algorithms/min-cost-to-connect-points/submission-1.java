class Solution {
    public int minCostConnectPoints(int[][] points) {
        int curNode = 0;
        int res = 0;
        int edges = 0;
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        while (edges < n - 1) {
            visited[curNode] = true;
            int minDist = Integer.MAX_VALUE;
            int minDistNode = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int curDist = calculateDistance(points[curNode], points[i]);
                    dist[i] = Math.min(curDist, dist[i]);

                    if (dist[i] < minDist) {
                        minDist = dist[i];
                        minDistNode = i;
                    }

                    // if (curDist < minDist) {
                    //     dist[i] = curDist;
                    //     minDist = curDist;
                    //     minDistNode = i;
                    // }
                
                }
            }

            edges ++;
            res += minDist;
            curNode = minDistNode;
        }

        return res;
    }

    public int calculateDistance(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }
}
