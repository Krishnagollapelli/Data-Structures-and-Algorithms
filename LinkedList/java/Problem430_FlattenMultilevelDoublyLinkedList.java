/**
 * Problem 430: Flatten a Multilevel Doubly Linked List
 * Difficulty: Medium
 * 
 * Flatten a multilevel doubly linked list where nodes may have a child pointer.
 * 
 * Approach: DFS - when encounter child, process it before continuing
 * Time: O(n), Space: O(n) for recursion
 */
class Node {
    public int val;
    public Node prev, next, child;
}

public class Problem430_FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }
    
    private Node flattenDFS(Node node) {
        Node current = node;
        Node last = null;
        
        while (current != null) {
            Node next = current.next;
            
            if (current.child != null) {
                Node childLast = flattenDFS(current.child);
                
                // Connect current with child
                current.next = current.child;
                current.child.prev = current;
                
                // Connect child's tail with next
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                
                current.child = null;
                last = childLast;
            } else {
                last = current;
            }
            
            current = next;
        }
        
        return last;
    }
}
