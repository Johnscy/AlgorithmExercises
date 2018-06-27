package Target_To_Offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //迭代
    public class Solution1 {
        public ListNode Merge(ListNode list1,ListNode list2) {
            ListNode list = new ListNode(-1);   //新链表的头结点
            ListNode cur = list;                    //指针
            while (list1 != null && list2 != null){
                if (list1.val <= list2.val){
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if (list1 != null)
                cur.next = list1;
            if (list2 != null)
                cur.next = list2;
            return list.next;
        }
    }

    //递归
    public class Solution2 {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;
            if (list1.val <= list2.val){
                list1.next = Merge(list1.next,list2);
                return list1;
            } else {
                list2.next = Merge(list1,list2.next);
                return list2;
            }
        }
    }

}
