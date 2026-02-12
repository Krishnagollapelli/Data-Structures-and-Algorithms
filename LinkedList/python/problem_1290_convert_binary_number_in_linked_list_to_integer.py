"""Problem 1290: Convert Binary Number in Linked List to Integer - Easy
Convert binary linked list to integer
Example: [1,0,1] → 5
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        result = 0
        
        while head:
            result = result * 2 + head.val
            head = head.next
        
        return result
