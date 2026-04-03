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
    public ListNode reverseList(ListNode head) {
     ListNode current = head;
     ListNode tmp;
     ListNode previous = null;

     while (current != null) {
        tmp = current.next;
        // update the links
        current.next = previous;

        // counter update rule 
        previous = current;
        current = tmp;
     }

     return previous;   
    }
}
