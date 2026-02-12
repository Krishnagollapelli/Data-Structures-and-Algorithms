"""Problem 160: Intersection of Two Linked Lists - Easy
Find the node where two linked lists intersect
Approach: Two pointers - redirect to other list when reaching end
Time: O(m + n), Space: O(1)
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        
        pA, pB = headA, headB
        
        # When pointers meet, they're either at intersection or both None
        while pA != pB:
            pA = headB if pA is None else pA.next
            pB = headA if pB is None else pB.next
        
        return pA
