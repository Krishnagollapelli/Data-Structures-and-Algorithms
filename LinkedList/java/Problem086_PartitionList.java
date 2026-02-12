/**
 * Problem 86: Partition List
 * Difficulty: Medium
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x 
 * come before nodes greater than or equal to x.
 * 
 * Example: [1,4,3,2,5,2], x = 3 → [1,2,2,4,3,5]
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0), greaterHead = new ListNode(0);
        ListNode less = lessHead, greater = greaterHead;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        less.next = greaterHead.next;
        return lessHead.next;
    }
}
