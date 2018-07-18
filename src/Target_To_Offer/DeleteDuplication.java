package Target_To_Offer;

import java.util.HashMap;
import java.util.Map;

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
    //HashMap
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null)
                return null;
            HashMap<Integer,Integer> map = new HashMap<>();
            ListNode node = pHead;
            int index = 1;
            while (node != null){
                if (!map.containsKey(node.val))
                    map.put(node.val,index++);
                else
                    map.put(node.val,0);
                node = node.next;
            }
             entry =

        }
    }
}
