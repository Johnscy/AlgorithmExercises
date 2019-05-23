package LeetCode;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer_138 {

    //Definition for singly-linked list with a random pointer.
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    //在每个结点后面复制结点，设置好指向后断开两条链表
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null)
                return head;
            RandomListNode cur = head;
            while (cur != null){
                RandomListNode node = new RandomListNode(cur.label);
                node.next = cur.next;
                cur.next = node;
                cur = node.next;
            }
            cur = head;
            while (cur != null){
                RandomListNode node = cur.next;
                if (cur.random != null)
                    node.random = cur.random.next;
                cur = node.next;
            }
            cur = head;
            RandomListNode curList = head.next, ret = curList;
            while (cur != null){
                cur.next = curList.next;
                cur = cur.next;
                if (cur != null) {
                    curList.next = cur.next;
                    curList = curList.next;
                }else {
                    curList.next = null;
                }
            }
            return ret;
        }
    }
}
