package LeetCode;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
 * as shown in the example below.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 * Example:
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenAMultilevelDoublyLinkedList_430 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    //Iteration
    class Solution_Iteration {
        public Node flatten(Node head) {
            if (head == null)   return null;
            Node p = head;
            while (p != null){
                if (p.child == null){
                    p = p.next;
                    continue;
                }
                Node node = p.child;
                while (node.next != null)
                    node = node.next;
                node.next = p.next;
                if (p.next != null) p.next.prev = node;
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
            return head;
        }
    }

    //Recursion1
    class Solution_Recursion1 {
        public Node flatten(Node head) {
            flattentail(head);
            return head;
        }

        private Node flattentail(Node head){
            if (head == null) return head;
            if (head.child == null){
                if (head.next == null)
                    return head;
                return flattentail(head.next);
            }else {
                Node child = head.child;
                head.child = null;  //及时将指向孩子的指针清空
                Node next = head.next;
                Node childtail = flattentail(child);
                head.next = child;
                child.prev = head;
                if (next != null){
                    childtail.next = next;
                    next.prev = childtail;
                    return flattentail(next);
                }
                return childtail;
            }
        }
    }

    //Recursion2
    class Solution_Recursion2 {
        Node pre = null;
        public Node flatten(Node head) {
            if (head == null)
                return head;
            if (pre != null){
                pre.next = head;
                head.prev = pre;
            }
            pre = head;
            Node next = head.next;
            flatten(head.child);
            head.child = null;
            flatten(next);
            return head;
        }
    }
}
