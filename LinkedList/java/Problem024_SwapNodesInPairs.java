/**
 * Problem 24: Swap Nodes in Pairs
 * Difficulty: Medium
 * 
 * Problem Statement:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * Example:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
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

public class Problem024_SwapNodesInPairs {
    
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            // Identify nodes to swap
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Perform the swap
            // prev -> first -> second -> rest
            // becomes
            // prev -> second -> first -> rest
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move prev pointer forward by 2 nodes
            prev = first;
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
        Problem024_SwapNodesInPairs solution = new Problem024_SwapNodesInPairs();
        
        ListNode head = createList(new int[]{1, 2, 3, 4});
        System.out.print("Original: ");
        printList(head);
        
        ListNode result = solution.swapPairs(head);
        System.out.print("After swapping pairs: ");
        printList(result);  // Output: [2,1,4,3]
    }
}
