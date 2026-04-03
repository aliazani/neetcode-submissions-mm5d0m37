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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;

        // fast is n nodes away from slow
        while (n > 0 && fast != null) {
            fast = fast.next;

            n--;
        }

        // shift fast till the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove the node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
