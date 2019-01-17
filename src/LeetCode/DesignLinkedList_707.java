package LeetCode;

/**
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 *
 * Implement these functions in your linked list class:
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 *
 * Example:
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 */
public class DesignLinkedList_707 {

    class MyLinkedList {
        class ListNode{
            int val;
            ListNode next;
            
            ListNode(int val){
                this.val = val;
            }
        }
        //可以使用头尾两指针，更快
        private ListNode curHead;
        //private ListNode curTail;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            curHead = null;
            //curTail = null;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index >= size)  return -1;
            ListNode getNode = curHead;
            while (index-- > 0){
                getNode = getNode.next;
            }
            return getNode.val;
        }

        /** Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.*/
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = curHead;
            curHead = newNode;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            if (curHead == null)
                curHead = newNode;
            else {
                ListNode pointer = curHead;
                while (pointer.next != null){
                    pointer = pointer.next;
                }
                pointer.next = newNode;
                newNode.next = null;
            }
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size)   return;
            else if (index == size)
                addAtTail(val);
            else {
                ListNode newNode = new ListNode(val);
                ListNode pointer = curHead;
                index--;
                while (index-- > 0)
                    pointer = pointer.next;
                newNode.next = pointer.next;
                pointer.next = newNode;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size)  return;
            else {
                ListNode pointer = curHead;
                index--;
                while (index-- > 0)
                    pointer = pointer.next;
                pointer.next = pointer.next.next;
                size--;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
