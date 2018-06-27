package Target_To_Offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归
    public class Solution1 {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null)  return head;
            ListNode next = head.next;
            head.next = null;
            ListNode newHead = ReverseList(next);   //递归到最后一个结点，newHead一直是指向尾结点（翻转后的头结点），并无其他作用
            next.next = head;
            return newHead;
        }
    }

    //迭代
    public class Solution2 {
        public ListNode ReverseList(ListNode head) {
            ListNode newList = new ListNode(-1);
            while (head != null){
                ListNode next = head.next;
                head.next = newList.next;
                newList.next = head;
                head = next;
            }
            return newList.next;    //newList是加的头链表
        }
    }
}
