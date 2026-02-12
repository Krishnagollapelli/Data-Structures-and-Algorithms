"""Problem 203: Remove Linked List Elements - Easy
Remove all nodes with value val
Example: [1,2,6,3,4,5,6], val=6 → [1,2,3,4,5]
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        current = dummy
        
        while current.next:
            if current.next.val == val:
                current.next = current.next.next
            else:
                current = current.next
        
        return dummy.next
