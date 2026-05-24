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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(list1 != null || list2 != null) {
            ListNode nextNode;
            if (list1 == null) {
                nextNode = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                nextNode = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    nextNode = list1;
                    list1 = list1.next;
                } else {
                    nextNode = list2;
                    list2 = list2.next;
                }
            }
            cur.next = nextNode;
            cur = cur.next;
        }

        return dummy.next;
    }
}