/**
 * Problem 109: Convert Sorted List to Binary Search Tree
 * Difficulty: Medium
 * 
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Example: [-10,-3,0,5,9] → Height-balanced BST
 * Time: O(n log n), Space: O(log n)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Problem109_ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        // Find middle using slow/fast pointers
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Disconnect left half
        if (prev != null) prev.next = null;
        
        // Middle becomes root
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}
