"""Problem 430: Flatten a Multilevel Doubly Linked List - Medium
Flatten multilevel doubly linked list with child pointers
Approach: DFS - process child before continuing
Time: O(n), Space: O(n) for recursion
"""
class Node:
    def __init__(self, val=0, prev=None, next=None, child=None):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:
    def flatten(self, head: Node) -> Node:
        if not head:
            return None
        self.flatten_dfs(head)
        return head
    
    def flatten_dfs(self, node: Node) -> Node:
        current = node
        last = None
        
        while current:
            next_node = current.next
            
            if current.child:
                child_last = self.flatten_dfs(current.child)
                
                # Connect current with child
                current.next = current.child
                current.child.prev = current
                
                # Connect child's tail with next
                if next_node:
                    child_last.next = next_node
                    next_node.prev = child_last
                
                current.child = None
                last = child_last
            else:
                last = current
            
            current = next_node
        
        return last
