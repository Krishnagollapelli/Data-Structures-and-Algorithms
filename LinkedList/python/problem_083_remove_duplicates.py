"""
Problem 83: Remove Duplicates from Sorted List
Difficulty: Easy

Problem Statement:
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.

Example:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Time Complexity: O(n)
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        current = head
        
        while current and current.next:
            if current.val == current.next.val:
                # Skip duplicate
                current.next = current.next.next
            else:
                # Move to next distinct value
                current = current.next
        
        return head

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
    head = create_list([1, 1, 2, 3, 3])
    print("Original: ", end="")
    print_list(head)
    result = solution.deleteDuplicates(head)
    print("After removing duplicates: ", end="")
    print_list(result)
