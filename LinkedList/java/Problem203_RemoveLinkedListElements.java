/**
 * Problem 203: Remove Linked List Elements
 * Difficulty: Easy
 * 
 * Remove all nodes with value val.
 * Example: [1,2,6,3,4,5,6], val=6 → [1,2,3,4,5]
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}
