# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

        slow = head
        fast = head.next

        # 1. find middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # 2. reverse second half
        second = slow.next
        slow.next = None
        prev = None

        while second:
            tmp = second.next
            
            second.next = prev
            prev = second
            second = tmp

        # 3. merge two halves
        first = head
        second = prev

        while second:
            tmp1 = first.next
            tmp2 = second.next

            first.next = second
            second.next = tmp1

            first = tmp1
            second = tmp2