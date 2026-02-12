# LeetCode Linked List Problems - Java & Python Solutions

A comprehensive collection of LeetCode linked list problems with detailed solutions in both Java and Python.

## 📚 Problem List

| # | Problem | Difficulty | Java | Python |
|---|---------|------------|------|--------|
| 2 | Add Two Numbers | Medium | ✅ | ✅ |
| 19 | Remove Nth Node From End of List | Medium | ✅ | ✅ |
| 21 | Merge Two Sorted Lists | Easy | ✅ | ✅ |
| 24 | Swap Nodes in Pairs | Medium | ✅ | ✅ |
| 61 | Rotate List | Medium | ✅ | ✅ |
| 82 | Remove Duplicates from Sorted List II | Medium | ✅ | ✅ |
| 83 | Remove Duplicates from Sorted List | Easy | ✅ | ✅ |
| 86 | Partition List | Medium | ✅ | ✅ |
| 92 | Reverse Linked List II | Medium | ✅ | ✅ |
| 109 | Convert Sorted List to Binary Search Tree | Medium | ✅ | ✅ |
| 141 | Linked List Cycle | Easy | ✅ | ✅ |
| 160 | Intersection of Two Linked Lists | Easy | ✅ | ✅ |
| 203 | Remove Linked List Elements | Easy | ✅ | ✅ |
| 206 | Reverse Linked List | Easy | ✅ | ✅ |
| 234 | Palindrome Linked List | Easy | ✅ | ✅ |
| 430 | Flatten a Multilevel Doubly Linked List | Medium | ✅ | ✅ |
| 707 | Design Linked List | Medium | ✅ | ✅ |
| 876 | Middle of the Linked List | Easy | ✅ | ✅ |
| 1290 | Convert Binary Number in a Linked List to Integer | Easy | ✅ | ✅ |
| 2095 | Delete the Middle Node of a Linked List | Medium | ✅ | ✅ |

## 🗂️ Repository Structure

```
leetcode-solutions/
├── java/
│   ├── Problem002_AddTwoNumbers.java
│   ├── Problem019_RemoveNthFromEnd.java
│   ├── Problem021_MergeTwoSortedLists.java
│   ├── Problem024_SwapNodesInPairs.java
│   ├── Problem061_RotateList.java
│   ├── Problem082_RemoveDuplicatesII.java
│   ├── Problem083_RemoveDuplicates.java
│   ├── Problem086_PartitionList.java
│   ├── Problem092_ReverseLinkedListII.java
│   ├── Problem109_ConvertSortedListToBST.java
│   ├── Problem141_LinkedListCycle.java
│   ├── Problem160_IntersectionOfTwoLinkedLists.java
│   ├── Problem203_RemoveLinkedListElements.java
│   ├── Problem206_ReverseLinkedList.java
│   ├── Problem234_PalindromeLinkedList.java
│   ├── Problem430_FlattenMultilevelDoublyLinkedList.java
│   ├── Problem707_DesignLinkedList.java
│   ├── Problem876_MiddleOfTheLinkedList.java
│   ├── Problem1290_ConvertBinaryNumberInLinkedListToInteger.java
│   └── Problem2095_DeleteTheMiddleNodeOfLinkedList.java
│
├── python/
│   ├── problem_002_add_two_numbers.py
│   ├── problem_019_remove_nth_from_end.py
│   ├── problem_021_merge_two_sorted_lists.py
│   ├── problem_024_swap_nodes_in_pairs.py
│   ├── problem_061_rotate_list.py
│   ├── problem_082_remove_duplicates_ii.py
│   ├── problem_083_remove_duplicates.py
│   ├── problem_086_partition_list.py
│   ├── problem_092_reverse_linked_list_ii.py
│   ├── problem_109_convert_sorted_list_to_bst.py
│   ├── problem_141_linked_list_cycle.py
│   ├── problem_160_intersection_of_two_linked_lists.py
│   ├── problem_203_remove_linked_list_elements.py
│   ├── problem_206_reverse_linked_list.py
│   ├── problem_234_palindrome_linked_list.py
│   ├── problem_430_flatten_multilevel_doubly_linked_list.py
│   ├── problem_707_design_linked_list.py
│   ├── problem_876_middle_of_the_linked_list.py
│   ├── problem_1290_convert_binary_number_in_linked_list_to_integer.py
│   └── problem_2095_delete_the_middle_node_of_linked_list.py
│
└── README.md
```

## 💡 Key Patterns & Techniques

### 1. **Two Pointers (Slow/Fast)**
- **Problems**: 19, 141, 160, 234, 876, 2095
- **Use Case**: Finding middle, cycle detection, nth from end
- **Pattern**: `slow` moves 1 step, `fast` moves 2 steps

### 2. **Dummy Node**
- **Problems**: 2, 19, 21, 24, 82, 83, 86, 92, 203
- **Use Case**: Simplifies edge cases (removing head, empty list)
- **Pattern**: `dummy = new ListNode(0); dummy.next = head;`

### 3. **Reverse Linked List**
- **Problems**: 24, 92, 206, 234
- **Use Case**: Reversing entire list or sublist
- **Pattern**: Three pointers - `prev`, `current`, `next`

### 4. **Partition/Split**
- **Problems**: 86, 109
- **Use Case**: Splitting list into two separate lists
- **Pattern**: Maintain two separate lists, then merge

### 5. **Cycle Detection (Floyd's Algorithm)**
- **Problems**: 141
- **Use Case**: Detect if list has a cycle
- **Pattern**: Two pointers - when they meet, cycle exists

## 🚀 Running the Code

### Java
```bash
cd java
javac Problem002_AddTwoNumbers.java
java Problem002_AddTwoNumbers
```

### Python
```bash
cd python
python3 problem_002_add_two_numbers.py
```

## 📖 Code Features

Each solution includes:
- ✅ **Detailed problem description**
- ✅ **Example test cases**
- ✅ **Time and space complexity analysis**
- ✅ **Clean, well-commented code**
- ✅ **Helper methods for testing**
- ✅ **Multiple approaches where applicable**

## 🎯 Difficulty Distribution

- **Easy**: 9 problems
- **Medium**: 11 problems
- **Total**: 20 problems

## 📝 Common Time Complexities

- **O(n)**: Most traversal operations
- **O(1)**: Pointer manipulation operations
- **O(n log n)**: Divide and conquer (e.g., sorted list to BST)

## 🔑 Tips for Linked List Problems

1. **Always check for null/None**: Prevent null pointer exceptions
2. **Use dummy nodes**: Simplifies handling head node
3. **Draw diagrams**: Visualize pointer movements
4. **Consider edge cases**: Empty list, single node, two nodes
5. **Practice pointer manipulation**: Core skill for linked lists

## 📚 Learning Path

**Beginner** (Start here):
- 206 (Reverse Linked List)
- 876 (Middle of Linked List)
- 83 (Remove Duplicates)
- 21 (Merge Two Sorted Lists)

**Intermediate**:
- 19 (Remove Nth From End)
- 24 (Swap Nodes in Pairs)
- 141 (Linked List Cycle)
- 234 (Palindrome Linked List)

**Advanced**:
- 2 (Add Two Numbers)
- 92 (Reverse Linked List II)
- 109 (Convert Sorted List to BST)
- 430 (Flatten Multilevel Doubly Linked List)

## 🤝 Contributing

Feel free to:
- Add more problems
- Optimize existing solutions
- Add alternative approaches
- Improve documentation

## 📄 License

This repository is for educational purposes. All problems are from LeetCode.

## 🔗 Resources

- [LeetCode](https://leetcode.com/)
- [Linked List Visualization](https://visualgo.net/en/list)

---

**Happy Coding! 🎉**

*Last Updated: February 2026*
