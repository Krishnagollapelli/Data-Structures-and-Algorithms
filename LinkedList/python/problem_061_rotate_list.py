"""
Problem 61: Rotate List
Difficulty: Medium

Problem Statement:
Given the head of a linked list, rotate the list to the right by k places.

Example:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Approach:
1. Find length of list
2. Connect tail to head (make it circular)
3. Find new tail position: (length - k % length - 1)
4. Break the circle at new tail

Time Complexity: O(n)
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k == 0:
            return head
        
        # Step 1: Find length and get to tail
        tail = head
        length = 1
        while tail.next:
            tail = tail.next
            length += 1
        
        # Step 2: Make it circular
        tail.next = head
        
        # Step 3: Find new tail position
        # After rotation, new tail is at position (length - k % length - 1)
        k = k % length  # Handle k > length
        steps_to_new_tail = length - k - 1
        
        new_tail = head
        for _ in range(steps_to_new_tail):
            new_tail = new_tail.next
        
        # Step 4: Break the circle
        new_head = new_tail.next
        new_tail.next = None
        
        return new_head

def create_list(arr):
    if not arr:
        return None
    head = ListNode(arr[0])
    current = head
    for i in range(1, len(arr)):
        current.next = ListNode(arr[i])
        current = current.next
    return head

def print_list(head):
    result = []
    current = head
    while current:
        result.append(str(current.val))
        current = current.next
    print("[" + ",".join(result) + "]")

if __name__ == "__main__":
    solution = Solution()
    
    head = create_list([1, 2, 3, 4, 5])
    print("Original: ", end="")
    print_list(head)
    
    result = solution.rotateRight(head, 2)
    print("After rotating by 2: ", end="")
    print_list(result)  # Output: [4,5,1,2,3]
