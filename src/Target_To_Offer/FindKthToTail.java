package Target_To_Offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：假设链表长N。在头结点处放俩指针P1、P2，将P1移至k处，然后P1、P2一起移动，直至P1到达尾结点，则P2的位置就是倒数第k个。
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if (head == null)   return null;
            ListNode p1, p2;
            p1 = p2 = head;
            while (p1 != null && k-- > 0)
                p1 = p1.next;
            if (k > 0)  return null;    //k太大，超出链表长度
            while (p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
}
