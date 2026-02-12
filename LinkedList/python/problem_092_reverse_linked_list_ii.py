"""Problem 92: Reverse Linked List II - Medium
Reverse nodes from position left to right
Example: [1,2,3,4,5], left=2, right=4 → [1,4,3,2,5]
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        if not head or left == right:
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        
        for _ in range(left - 1):
            prev = prev.next
        
        current = prev.next
        for _ in range(right - left):
            next_node = current.next
            current.next = next_node.next
            next_node.next = prev.next
            prev.next = next_node
        
        return dummy.next
