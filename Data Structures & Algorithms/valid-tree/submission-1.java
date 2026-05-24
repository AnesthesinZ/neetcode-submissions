class Solution {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        if (dfsCycle(0, adjList, visited, -1)) {
            return false;
        }

        int c = 0;
        for (boolean v: visited) {
            if (v) {
                c++;
            }
        }

        return c == n;
    }

    public boolean dfsCycle(int nodeId, 
                            Map<Integer, List<Integer>> adjList, 
                            boolean[] visited, 
                            int parentNode) {
        visited[nodeId] = true;

        for (int nei : adjList.getOrDefault(nodeId, List.of())) {
            if (!visited[nei]) {
                if (dfsCycle(nei, adjList, visited, nodeId)) {
                    return true;
                }
            } else if (nei != parentNode) {
                return true;
            }
        }

        return false;
    }
}
