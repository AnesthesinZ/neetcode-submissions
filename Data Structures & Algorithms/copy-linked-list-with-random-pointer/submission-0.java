/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mapping = new HashMap<>();

        Node cur = head;
        Node prev = null;
        // copy the list without random.
        while (cur != null) {
            Node newNode = new Node(cur.val);
            if (prev != null) {
                prev.next = newNode;
            }
            mapping.put(cur, newNode);
            prev = newNode;
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node randomO = cur.random;
            if (randomO != null) {
                Node newNode = mapping.get(cur);
                Node randomN = mapping.getOrDefault(randomO, null);
                newNode.random = randomN;
            }
            cur = cur.next;
        }

        return mapping.get(head);
    }
}
