"""Problem 86: Partition List - Medium
Given a linked list and value x, partition nodes < x before nodes >= x
Example: [1,4,3,2,5,2], x=3 → [1,2,2,4,3,5]
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        less_head, greater_head = ListNode(0), ListNode(0)
        less, greater = less_head, greater_head
        
        while head:
            if head.val < x:
                less.next = head
                less = less.next
            else:
                greater.next = head
                greater = greater.next
            head = head.next
        greater.next = None
        less.next = greater_head.next
        return less_head.next
