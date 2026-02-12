"""Problem 206: Reverse Linked List - Easy
Reverse a singly linked list
Example: [1,2,3,4,5] → [5,4,3,2,1]
Time: O(n), Space: O(1) iterative, O(n) recursive
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    # Iterative approach
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        current = head
        
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        
        return prev
    
    # Recursive approach
    def reverseListRecursive(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        
        new_head = self.reverseListRecursive(head.next)
        head.next.next = head
        head.next = None
        
        return new_head
