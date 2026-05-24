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
    public void reorderList(ListNode head) {
        
        ListNode middle = findMiddleNode(head);
        ListNode reversed = reverseFrom(middle);

        ListNode curHead = head;
        ListNode nextHead = reversed;

        while (curHead!= null) {
            ListNode tmp = curHead.next;
            
            curHead.next = nextHead;
            curHead = curHead.next;
            nextHead = tmp;
        }
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseFrom(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }
}
