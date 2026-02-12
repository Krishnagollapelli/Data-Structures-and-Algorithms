/**
 * Problem 1290: Convert Binary Number in a Linked List to Integer
 * Difficulty: Easy
 * 
 * Convert binary number represented as linked list to integer.
 * Example: [1,0,1] → 5
 * 
 * Time: O(n), Space: O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem1290_ConvertBinaryNumberInLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        
        return result;
    }
}
