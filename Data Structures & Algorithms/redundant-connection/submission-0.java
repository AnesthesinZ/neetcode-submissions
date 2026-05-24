class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inde = new HashMap<>();
        Set<Integer> cycleNodes = new HashSet<>();
       

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);

            inde.put(edge[0], inde.getOrDefault(edge[0], 0) + 1);
            inde.put(edge[1], inde.getOrDefault(edge[1], 0) + 1);

            cycleNodes.add(edge[0]);
            cycleNodes.add(edge[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        
        // indegree 1 cannot form a cycle.
        inde.forEach((k, v)-> {
            if (v == 1) {
                q.add(k);
            }
        });

        while (!q.isEmpty()) {
            int nodeId = q.poll();
            cycleNodes.remove(nodeId);

            for (int nei : adjList.get(nodeId)) {
                inde.put(nei, inde.getOrDefault(nei, 0) - 1);
                if (inde.get(nei) == 1)  {
                    q.add(nei);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (cycleNodes.contains(edges[i][0]) && cycleNodes.contains(edges[i][1])) {
                return edges[i];
            }
        }

        
        return new int[] {};
    }
}
