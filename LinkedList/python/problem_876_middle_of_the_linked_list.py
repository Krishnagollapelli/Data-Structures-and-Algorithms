"""Problem 876: Middle of the Linked List - Easy
Return middle node (second one if two middles)
Example: [1,2,3,4,5] → 3
Approach: Slow/fast pointers
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        slow = fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        return slow
