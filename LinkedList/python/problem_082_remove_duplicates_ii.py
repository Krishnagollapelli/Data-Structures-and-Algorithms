"""
Problem 82: Remove Duplicates from Sorted List II
Difficulty: Medium

Problem Statement:
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

Example:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Time Complexity: O(n)
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        
        while head:
            # Check if current node has duplicates
            if head.next and head.val == head.next.val:
                # Skip all nodes with same value
                while head.next and head.val == head.next.val:
                    head = head.next
                # Connect prev to node after duplicates
                prev.next = head.next
            else:
                # No duplicates, move prev forward
                prev = prev.next
            head = head.next
        
        return dummy.next

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
    head = create_list([1, 2, 3, 3, 4, 4, 5])
    print("Original: ", end="")
    print_list(head)
    result = solution.deleteDuplicates(head)
    print("After removing duplicates: ", end="")
    print_list(result)
