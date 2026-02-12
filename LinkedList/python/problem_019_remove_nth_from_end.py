"""
Problem 19: Remove Nth Node From End of List
Difficulty: Medium

Problem Statement:
Given the head of a linked list, remove the nth node from the end of the list
and return its head.

Example:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Approach: Two-Pointer Technique
1. Use two pointers with n nodes gap between them
2. When fast pointer reaches end, slow pointer is at node before target

Time Complexity: O(L) where L is length of list
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # Create dummy node to handle edge case of removing head
        dummy = ListNode(0)
        dummy.next = head
        
        fast = dummy
        slow = dummy
        
        # Move fast pointer n+1 steps ahead
        # This creates gap of n nodes between fast and slow
        for _ in range(n + 1):
            fast = fast.next
        
        # Move both pointers until fast reaches end
        # When fast is at end, slow is just before node to remove
        while fast:
            fast = fast.next
            slow = slow.next
        
        # Remove the nth node from end
        slow.next = slow.next.next
        
        return dummy.next

# Helper functions
def create_list(arr):
    """Create linked list from array"""
    if not arr:
        return None
    head = ListNode(arr[0])
    current = head
    for i in range(1, len(arr)):
        current.next = ListNode(arr[i])
        current = current.next
    return head

def print_list(head):
    """Print linked list"""
    result = []
    current = head
    while current:
        result.append(str(current.val))
        current = current.next
    print("[" + ",".join(result) + "]")

# Test
if __name__ == "__main__":
    solution = Solution()
    
    # Test case: Remove 2nd node from end
    head = create_list([1, 2, 3, 4, 5])
    print("Original: ", end="")
    print_list(head)
    
    result = solution.removeNthFromEnd(head, 2)
    print("After removing 2nd from end: ", end="")
    print_list(result)  # Output: [1,2,3,5]
