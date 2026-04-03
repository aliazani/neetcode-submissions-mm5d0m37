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
        ListNode slow = head;
        ListNode fast = head.next;

        // find the middle point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // we do have beginning of second half
        ListNode second = slow.next;
        slow.next = null;

        // reversing the links
        ListNode previous = null;

        while (second != null) {
            ListNode temp = second.next;
            // previous      s      s.next
            //               1       -> 2      -> 3
            //   <- 1
            second.next = previous;
            previous = second;
            // moving forward
            second = temp;
        }

        // merge two parts
        ListNode first = head;
        second = previous;

        while (second != null) {
            // 1 -> 2 -> 3
            // 4 -> 5 -> 6
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            // 1 -> 4 -> 2 -> 3
            first.next = second;
            second.next = tmp1;

            first = tmp1;
            // 1 -> 2 -> 3
            //      t1
            second = tmp2;
            // 4 -> 5 -> 6
            //      t2 
        }
    }
}
