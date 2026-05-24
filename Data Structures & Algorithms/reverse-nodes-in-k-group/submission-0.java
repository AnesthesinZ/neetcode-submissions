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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        ListNode start = head;
        while (start != null) {
            ListNode[] res = reverseFrom(start, k);
            cur.next = res[0];
            cur = start;
            start = res[1];
        }

        return dummyHead.next;
    }

    private ListNode[] reverseFrom(ListNode head, int n) {
        ListNode[] res = new ListNode[2];
        int i = 0;
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null && i < n) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            i++;
        }

        if (i != n) {
            return reverseFrom(prev, i);
        }

        // prev is the reversed head
        // cur is the next node before reverse
        res[0] = prev;
        res[1] = cur;

        return res;
    }
}
