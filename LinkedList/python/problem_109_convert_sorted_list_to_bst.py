"""Problem 109: Convert Sorted List to Binary Search Tree - Medium
Convert sorted linked list to height-balanced BST
Example: [-10,-3,0,5,9] → Height-balanced BST
Time: O(n log n), Space: O(log n)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return None
        if not head.next:
            return TreeNode(head.val)
        
        # Find middle using slow/fast pointers
        slow, fast, prev = head, head, None
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        
        # Disconnect left half
        if prev:
            prev.next = None
        
        # Middle becomes root
        root = TreeNode(slow.val)
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(slow.next)
        
        return root
