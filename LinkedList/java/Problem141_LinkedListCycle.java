/**
 * Problem 141: Linked List Cycle
 * Difficulty: Easy
 * 
 * Determine if a linked list has a cycle.
 * 
 * Approach: Floyd's Cycle Detection (slow/fast pointers)
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        
        return false;
    }
}
