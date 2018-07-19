package Target_To_Offer;
import java.util.HashMap;


/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //递归
    public class Solution_Recursion {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null)
                return pHead;
            ListNode node = pHead.next;

        }
    }

    //HashMap
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null)
                return pHead;
            HashMap<Integer,Integer> map = new HashMap<>();
            ListNode node = pHead;
            int count;
            while (node != null) {
                count = map.get(node.val);
                map.put(node.val, ++count);
            }
            while (map.get(pHead.val) > 1){
                pHead = pHead.next;
                if (pHead == null)
                    return null;
            }
            ListNode next = pHead.next;
            node = pHead;
            while (next != null){
                if (map.get(next.val) > 1){
                    next = next.next;
                    node.next = next;
                }
                else {
                    next = next.next;
                    node = node.next;
                }
            }
            return pHead;
        }
    }
}
