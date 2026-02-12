"""Problem 2095: Delete the Middle Node of a Linked List - Medium
Delete middle node and return modified list
Example: [1,3,4,7,1,2,6] → [1,3,4,1,2,6]
Approach: Slow/fast pointers with prev pointer
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def deleteMiddle(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return None
        
        slow, fast, prev = head, head, None
        
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        
        prev.next = slow.next
        return head
