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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int valueA = 0;
            int valueB = 0;

            if (l1 != null) {
                valueA = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                valueB = l2.val;
                l2 = l2.next;
            }

            int sum = valueA + valueB + carry;
            int nodeValue = sum % 10;
            carry = sum / 10;

            cur.next = new ListNode(nodeValue);
            cur = cur.next;
        }

        return dummy.next;
    }
}
