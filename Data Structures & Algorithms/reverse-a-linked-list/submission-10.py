# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        prev = None
        cur = head

        while cur != None:
            tmp = cur.next
            # update link cur
            cur.next = prev

            # update the counter
            prev = cur
            cur = tmp

        return prev


