class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // directed cycle dectection, using state 0, 1, 2, if found 1 again, cycle found
        // or use topological sort, start from indegree 0, decrease neighbor's indegree, if 
        // found indegree 0, add to queue, until nothing can be add, if no nodes, no cycle
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> states = new HashMap<>();

        for (int[] prereq : prerequisites) {
            int course = prereq[1];
            int dep = prereq[0];

            adjList.computeIfAbsent(course, k->new ArrayList<>()).add(dep);
            adjList.computeIfAbsent(dep, k->new ArrayList<>());
            states.put(course, 0);
            states.put(dep, 0);
        }

        for (int key : adjList.keySet()) {
            if (dfsCycle(key, adjList, states)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfsCycle(int courseId, 
                            Map<Integer, List<Integer>> adjList, 
                            Map<Integer, Integer> states) {
        if (states.get(courseId) == 1) {
            return true;
        }

        if (states.get(courseId) == 2) {
            return false;
        }

        boolean ret = false;

        states.put(courseId, 1);

        for (int child : adjList.get(courseId)) {
            ret = ret || dfsCycle(child, adjList, states);
        }

        states.put(courseId, 2);

        return ret;
    }
}
