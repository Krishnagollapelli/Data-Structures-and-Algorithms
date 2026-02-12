/**
 * Problem 21: Merge Two Sorted Lists
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Time Complexity: O(n + m) where n and m are lengths of the two lists
 * Space Complexity: O(1) - only pointer manipulation
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem021_MergeTwoSortedLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node to simplify logic
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Compare nodes from both lists and add smaller one
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes (if any)
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    // Recursive approach (alternative solution)
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        // Base cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Choose smaller node and recursively merge rest
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
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
        Problem021_MergeTwoSortedLists solution = new Problem021_MergeTwoSortedLists();
        
        ListNode l1 = createList(new int[]{1, 2, 4});
        ListNode l2 = createList(new int[]{1, 3, 4});
        
        ListNode result = solution.mergeTwoLists(l1, l2);
        System.out.print("Merged list: ");
        printList(result);  // Output: [1,1,2,3,4,4]
    }
}
