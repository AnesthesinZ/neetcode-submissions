class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to  = ticket.get(1);

            adjList.computeIfAbsent(from, k-> new PriorityQueue<>()).add(to);
        }

        List<String> path = new ArrayList<>();
        dfs(adjList, "JFK", path);
        Collections.reverse(path);
        return path;
    }


    public void dfs(Map<String, PriorityQueue<String>> adjList, 
                    String start, 
                    List<String> path) {
        PriorityQueue<String> q = adjList.get(start);

        while (q != null && !q.isEmpty()) {
            String dest = q.poll();
            dfs(adjList, dest, path);
        }

        path.add(start);
    }
}
