/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b)-> Integer.compare(a.val, b.val));

        for (ListNode list : lists) {
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        

        return dummyHead.next;
    }
}
