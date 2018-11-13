package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists_23 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //PriorityQueue
    class Solution_PriorityQueue {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1)
                return null;
            else if (lists.length == 1)
                return lists[0];
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(o1, o2) -> (o1.val - o2.val));
            /*PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val == o2.val)
                        return 0;
                    else if (o1.val < o2.val)
                        return -1;
                    else
                        return 1;
                }
            });*/
            ListNode dummy = new ListNode(-1), tail = dummy;
            for (ListNode head : lists) {
                if (head != null)
                    pq.add(head);
            }
            while (!pq.isEmpty()){
                tail.next = pq.poll();
                tail = tail.next;
                if (tail.next != null)
                    pq.add(tail.next);
            }
            return dummy.next;
        }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1)
                return null;
            else if (lists.length == 1)
                return lists[0];
            else
                return partition(lists,0,lists.length - 1);
        }

        private ListNode partition(ListNode[] lists, int start, int end){
            if (start == end)
                return lists[start];
            if (start < end) {
                int mid = (start + end) / 2;
                ListNode l1 = partition(lists,start,mid);
                ListNode l2 = partition(lists,mid + 1, end);
                return merge(l1,l2);
            }else
                return null;
        }

        private ListNode merge(ListNode l1, ListNode l2){
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            if (l1.val < l2.val){
                l1.next = merge(l1.next,l2);
                return l1;
            }else{
                l2.next = merge(l1,l2.next);
                return l2;
            }
        }
    }

}
