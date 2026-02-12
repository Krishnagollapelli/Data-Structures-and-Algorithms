/**
 * Problem 92: Reverse Linked List II
 * Difficulty: Medium
 * 
 * Reverse nodes from position left to right.
 * Example: [1,2,3,4,5], left=2, right=4 → [1,4,3,2,5]
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 1; i < left; i++) prev = prev.next;
        
        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
