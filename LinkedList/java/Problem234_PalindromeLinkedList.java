/**
 * Problem 234: Palindrome Linked List
 * Difficulty: Easy
 * 
 * Determine if a linked list is a palindrome.
 * Example: [1,2,2,1] → true
 * 
 * Approach: Find middle, reverse second half, compare
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverse(slow.next);
        
        // Compare
        ListNode p1 = head, p2 = secondHalf;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
