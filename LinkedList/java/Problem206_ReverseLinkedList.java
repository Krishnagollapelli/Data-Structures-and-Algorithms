/**
 * Problem 206: Reverse Linked List
 * Difficulty: Easy
 * 
 * Reverse a singly linked list.
 * Example: [1,2,3,4,5] → [5,4,3,2,1]
 * Time: O(n), Space: O(1) iterative, O(n) recursive
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem206_ReverseLinkedList {
    // Iterative approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Recursive approach
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
