class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] edge: edges) {
            adjList.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }

        int count = 0;
        for (int nodeId : adjList.keySet()) {
            if (!visited.contains(nodeId)) {
                dfs(nodeId, adjList, visited);
                count ++;
            }
        }

        return count + n - visited.size();
    }

    public void dfs(int nodeId, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        visited.add(nodeId);

        for (int nei : adjList.get(nodeId)) {
            if (!visited.contains(nei)) {
                dfs(nei, adjList, visited);
            }
        }
    }
}
