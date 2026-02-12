"""Problem 141: Linked List Cycle - Easy
Determine if linked list has a cycle
Approach: Floyd's Cycle Detection (slow/fast pointers)
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head or not head.next:
            return False
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        
        return False
