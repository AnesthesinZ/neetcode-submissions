class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        Map<Integer, List<Integer>> adjLists = new HashMap<>();

        for (int[] prereq : prerequisites) {
            // dep -> course
            int course = prereq[0];
            int dep = prereq[1];

            adjLists.computeIfAbsent(dep, k -> new ArrayList<>()).add(course);
            adjLists.computeIfAbsent(course, k -> new ArrayList<>());

            ind[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int courseId = q.poll();
            order.add(courseId);

            for (int course : adjLists.getOrDefault(courseId, new ArrayList<>())) {
                ind[course] --;
                if (ind[course] == 0) {
                    q.add(course);
                }
            }
        }

        if (order.size() == numCourses) {
            return order.stream().mapToInt(i-> i).toArray();
        }

        return new int[] {};
    }
}
