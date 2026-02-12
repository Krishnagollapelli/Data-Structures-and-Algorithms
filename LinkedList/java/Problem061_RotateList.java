/**
 * Problem 61: Rotate List
 * Difficulty: Medium
 * 
 * Problem Statement:
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * 
 * Approach:
 * 1. Find length of list
 * 2. Connect tail to head (make it circular)
 * 3. Find new tail position: (length - k % length - 1)
 * 4. Break the circle at new tail
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

public class Problem061_RotateList {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find length and get to tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Make it circular
        tail.next = head;
        
        // Step 3: Find new tail position
        // After rotation, new tail is at position (length - k % length - 1)
        k = k % length;  // Handle k > length
        int stepsToNewTail = length - k - 1;
        
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
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
        Problem061_RotateList solution = new Problem061_RotateList();
        
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        printList(head);
        
        ListNode result = solution.rotateRight(head, 2);
        System.out.print("After rotating by 2: ");
        printList(result);  // Output: [4,5,1,2,3]
    }
}
