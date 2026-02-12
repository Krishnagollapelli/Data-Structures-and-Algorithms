/**
 * Problem 19: Remove Nth Node From End of List
 * Difficulty: Medium
 * 
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Approach: Two-Pointer Technique
 * 1. Use two pointers with n nodes gap between them
 * 2. When fast pointer reaches end, slow pointer is at node before target
 * 
 * Time Complexity: O(L) where L is length of list
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem019_RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create dummy node to handle edge case of removing head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n+1 steps ahead
        // This creates gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches end
        // When fast is at end, slow is just before node to remove
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
    
    // Helper method to create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(",");
            current = current.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Problem019_RemoveNthFromEnd solution = new Problem019_RemoveNthFromEnd();
        
        // Test case: Remove 2nd node from end
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        printList(head);
        
        ListNode result = solution.removeNthFromEnd(head, 2);
        System.out.print("After removing 2nd from end: ");
        printList(result);  // Output: [1,2,3,5]
    }
}
