/**
 * Problem 160: Intersection of Two Linked Lists
 * Difficulty: Easy
 * 
 * Find the node where two linked lists intersect.
 * 
 * Approach: Two pointers - when one reaches end, redirect to other list's head
 * Time: O(m + n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // When pointers meet, they're either at intersection or both null
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        return pA;
    }
}
