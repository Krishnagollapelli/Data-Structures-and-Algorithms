/**
 * Problem 876: Middle of the Linked List
 * Difficulty: Easy
 * 
 * Return the middle node of the linked list. If two middle nodes, return the second.
 * Example: [1,2,3,4,5] → 3
 * 
 * Approach: Slow/fast pointers
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
