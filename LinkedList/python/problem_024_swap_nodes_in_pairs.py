"""
Problem 24: Swap Nodes in Pairs
Difficulty: Medium

Problem Statement:
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)

Example:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Time Complexity: O(n)
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # Dummy node to handle edge cases
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        
        while prev.next and prev.next.next:
            # Identify nodes to swap
            first = prev.next
            second = prev.next.next
            
            # Perform the swap
            # prev -> first -> second -> rest
            # becomes
            # prev -> second -> first -> rest
            first.next = second.next
            second.next = first
            prev.next = second
            
            # Move prev pointer forward by 2 nodes
            prev = first
        
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
    
    head = create_list([1, 2, 3, 4])
    print("Original: ", end="")
    print_list(head)
    
    result = solution.swapPairs(head)
    print("After swapping pairs: ", end="")
    print_list(result)  # Output: [2,1,4,3]
