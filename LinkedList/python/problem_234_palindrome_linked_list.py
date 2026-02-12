"""Problem 234: Palindrome Linked List - Easy
Determine if linked list is a palindrome
Example: [1,2,2,1] → true
Approach: Find middle, reverse second half, compare
Time: O(n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True
        
        # Find middle
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse second half
        second_half = self.reverse(slow.next)
        
        # Compare
        p1, p2 = head, second_half
        while p2:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        
        return True
    
    def reverse(self, head: ListNode) -> ListNode:
        prev = None
        while head:
            next_node = head.next
            head.next = prev
            prev = head
            head = next_node
        return prev
