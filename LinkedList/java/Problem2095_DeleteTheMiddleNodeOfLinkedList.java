/**
 * Problem 2095: Delete the Middle Node of a Linked List
 * Difficulty: Medium
 * 
 * Delete the middle node and return head of modified list.
 * Example: [1,3,4,7,1,2,6] → [1,3,4,1,2,6]
 * 
 * Approach: Slow/fast pointers with prev pointer
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem2095_DeleteTheMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head, prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;
        return head;
    }
}
