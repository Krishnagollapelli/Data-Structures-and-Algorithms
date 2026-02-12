"""
Problem 21: Merge Two Sorted Lists
Difficulty: Easy

Problem Statement:
Merge two sorted linked lists and return it as a sorted list.
The list should be made by splicing together the nodes of the first two lists.

Example:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Time Complexity: O(n + m) where n and m are lengths of the two lists
Space Complexity: O(1) - only pointer manipulation
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # Dummy node to simplify logic
        dummy = ListNode(0)
        current = dummy
        
        # Compare nodes from both lists and add smaller one
        while l1 and l2:
            if l1.val <= l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next
            current = current.next
        
        # Attach remaining nodes (if any)
        current.next = l1 if l1 else l2
        
        return dummy.next
    
    # Recursive approach (alternative solution)
    def mergeTwoListsRecursive(self, l1: ListNode, l2: ListNode) -> ListNode:
        # Base cases
        if not l1:
            return l2
        if not l2:
            return l1
        
        # Choose smaller node and recursively merge rest
        if l1.val <= l2.val:
            l1.next = self.mergeTwoListsRecursive(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoListsRecursive(l1, l2.next)
            return l2

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
    
    l1 = create_list([1, 2, 4])
    l2 = create_list([1, 3, 4])
    
    result = solution.mergeTwoLists(l1, l2)
    print("Merged list: ", end="")
    print_list(result)  # Output: [1,1,2,3,4,4]
