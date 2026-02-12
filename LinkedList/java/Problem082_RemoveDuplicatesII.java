/**
 * Problem 82: Remove Duplicates from Sorted List II
 * Difficulty: Medium
 * 
 * Problem Statement:
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * 
 * Example:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem082_RemoveDuplicatesII {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null) {
            // Check if current node has duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to node after duplicates
                prev.next = head.next;
            } else {
                // No duplicates, move prev forward
                prev = prev.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
    
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
        Problem082_RemoveDuplicatesII solution = new Problem082_RemoveDuplicatesII();
        
        ListNode head = createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.print("Original: ");
        printList(head);
        
        ListNode result = solution.deleteDuplicates(head);
        System.out.print("After removing duplicates: ");
        printList(result);  // Output: [1,2,5]
    }
}
