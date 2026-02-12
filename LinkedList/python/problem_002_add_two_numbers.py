"""
Problem 2: Add Two Numbers
Difficulty: Medium

Problem Statement:
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

Example:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807

Time Complexity: O(max(m, n)) where m and n are lengths of the two lists
Space Complexity: O(max(m, n)) for the result list
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_head = ListNode(0)  # Dummy node to simplify edge cases
        current = dummy_head
        carry = 0  # Track carry for addition
        
        # Process both lists until both are exhausted and no carry remains
        while l1 or l2 or carry:
            # Get values from current nodes (0 if node is None)
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            # Calculate sum and new carry
            total = val1 + val2 + carry
            carry = total // 10  # Carry for next iteration
            digit = total % 10   # Current digit to store
            
            # Create new node with the digit
            current.next = ListNode(digit)
            current = current.next
            
            # Move to next nodes if they exist
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        
        return dummy_head.next  # Return actual head (skip dummy)

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
    
    # Test case: [2,4,3] + [5,6,4] = [7,0,8]
    l1 = create_list([2, 4, 3])
    l2 = create_list([5, 6, 4])
    result = solution.addTwoNumbers(l1, l2)
    
    print("Result: ", end="")
    print_list(result)  # Output: [7,0,8]
