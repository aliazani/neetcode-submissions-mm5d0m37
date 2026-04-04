# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists is None or len(lists) == 0: return None

        while len(lists) > 1:
            res = []

            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if i+1 < len(lists) else None

                res.append(self.mergeLists(l1, l2))
            
            lists = res
        
        return lists[0]

    
    def mergeLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy: ListNode = ListNode()
        current: ListNode = dummy

        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                current.next = l1

                l1 = l1.next
            else:
                current.next = l2

                l2 = l2.next

            current = current.next
        

        if l1 is not None: current.next = l1
        if l2 is not None: current.next = l2


        return dummy.next
