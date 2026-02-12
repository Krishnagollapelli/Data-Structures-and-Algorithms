/**
 * Problem 83: Remove Duplicates from Sorted List
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * 
 * Example:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

public class Problem083_RemoveDuplicates {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip duplicate
                current.next = current.next.next;
            } else {
                // Move to next distinct value
                current = current.next;
            }
        }
        
        return head;
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
        Problem083_RemoveDuplicates solution = new Problem083_RemoveDuplicates();
        ListNode head = createList(new int[]{1, 1, 2, 3, 3});
        System.out.print("Original: ");
        printList(head);
        ListNode result = solution.deleteDuplicates(head);
        System.out.print("After removing duplicates: ");
        printList(result);
    }
}
