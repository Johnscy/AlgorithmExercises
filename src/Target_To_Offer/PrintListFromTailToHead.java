package Target_To_Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead{
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归
    public class Solution1 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            if(listNode != null){
                ret.addAll(printListFromTailToHead(listNode.next));
                ret.add(listNode.val);
            }
            return ret;
        }
    }

    //利用ArrayList的头插法
    public class Solution2 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            while(listNode != null){
                ret.add(0,listNode.val);
                listNode = listNode.next;
            }
            return ret;
        }
    }

    //利用Collections.reverse()
    public class Solution3 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            while(listNode != null){
                ret.add(listNode.val);
                listNode = listNode.next;
            }
            Collections.reverse(ret);
            return ret;
        }
    }

    //用指针实现头插
    public class Solution4 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            ListNode head = new ListNode(-1);
            while(listNode != null){
                ListNode memo   = listNode.next;
                listNode.next   = head.next;
                head.next       = listNode;
                listNode        = memo;
            }
            head = head.next;   //head结点只有指针，没有值。
            while (head != null){
                ret.add(head.val);
                head = head.next;
            }
            return ret;
        }
    }

    //用栈
    public class Solution5 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.add(listNode.val);
                listNode = listNode.next;
            }
            ArrayList<Integer> ret = new ArrayList<>();
            while (!stack.isEmpty())
                ret.add(stack.pop());
            return ret;
        }
    }
}
