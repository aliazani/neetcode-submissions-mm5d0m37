# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        mergedHead: ListNode = ListNode()
        current = mergedHead

        while list1 is not None and list2 is not None:
            if list1.val <= list2.val:
                current.next = ListNode(list1.val)
                # update the pointers
                list1 = list1.next
            else:
                current.next = ListNode(list2.val)
                list2 = list2.next
            
            current = current.next
        
        while list1 is not None:
            current.next = ListNode(list1.val)
            
            list1 = list1.next
            current = current.next

        while list2 is not None:
            current.next = ListNode(list2.val)
            
            list2 = list2.next
            current = current.next

        return mergedHead.next