/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        return prepare(node, visited, map);
    }

    public Node prepare(Node cur, Set<Node> visited, Map<Node, Node> map) {
        Node cp = null;
        if (cur != null && !visited.contains(cur)) {
            visited.add(cur);
            cp = new Node(cur.val);
            map.put(cur, cp);

            for (Node n : cur.neighbors) {
                prepare(n, visited, map);
            }

            for (Node n: cur.neighbors) {
                cp.neighbors.add(map.get(n));
            }
        }
        return cp;
    }
}