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
        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode mergedHead = new ListNode(); // dummy
        ListNode current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                current.next = new ListNode(head2.val);
                head2 = head2.next;
            }

            current = current.next;
        }

        while (head1 != null) {
            current.next = new ListNode(head1.val);
            head1 = head1.next;
            current = current.next;
        }

        while (head2 != null) {
            current.next = new ListNode(head2.val);
            head2 = head2.next;
            current = current.next;
        }

        return mergedHead.next;
    }
}