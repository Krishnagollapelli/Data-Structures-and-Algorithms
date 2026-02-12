/**
 * Problem 2: Add Two Numbers
 * Difficulty: Medium
 * 
 * Problem Statement:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807
 * 
 * Time Complexity: O(max(m, n)) where m and n are lengths of the two lists
 * Space Complexity: O(max(m, n)) for the result list
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem002_AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify edge cases
        ListNode current = dummyHead;
        int carry = 0;  // Track carry for addition
        
        // Process both lists until both are exhausted and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from current nodes (0 if node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and new carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;  // Carry for next iteration
            int digit = sum % 10;  // Current digit to store
            
            // Create new node with the digit
            current.next = new ListNode(digit);
            current = current.next;
            
            // Move to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummyHead.next;  // Return actual head (skip dummy)
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
        Problem002_AddTwoNumbers solution = new Problem002_AddTwoNumbers();
        
        // Test case: [2,4,3] + [5,6,4] = [7,0,8]
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        
        System.out.print("Result: ");
        printList(result);  // Output: [7,0,8]
    }
}
