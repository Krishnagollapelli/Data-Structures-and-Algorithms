/**
 * Problem 707: Design Linked List
 * Difficulty: Medium
 * 
 * Design your own linked list implementation.
 * 
 * Operations: get, addAtHead, addAtTail, addAtIndex, deleteAtIndex
 * Time: O(1) for head/tail, O(k) for index k
 */
class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int val) { this.val = val; }
}

public class Problem707_DesignLinkedList {
    private MyListNode head;
    private int size;
    
    public Problem707_DesignLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        MyListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        MyListNode newNode = new MyListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }
        MyListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new MyListNode(val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        
        MyListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        MyListNode newNode = new MyListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        
        MyListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
}
