# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        slow = dummy
        fast = dummy

        # 1 -> 2 -> 3 -> 4
        # s         f
        # move fast n+1 steps ahead
        for _ in range(n + 1):
            fast = fast.next

        # 1 -> 2 -> 3 -> 4
        #      s         f
        # move both until fast reaches the end
        while fast:
            slow = slow.next
            fast = fast.next

        # remove nth node from end
        slow.next = slow.next.next

        return dummy.next