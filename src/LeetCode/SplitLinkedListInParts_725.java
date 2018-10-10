package LeetCode;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
 * This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list,
 * and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size
 */
public class SplitLinkedListInParts_725 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] res = new ListNode[k];
            if (root == null || k < 1)
                return res;
            int len = 0;
            for (ListNode node = root;node != null;node = node.next)
                len++;
            int n = len / k, r = len % k; //r为余数，用来平均分给前r个部分，因为规定每个部分长度相差不超过1
            ListNode node = root, pre = null;
            for (int i = 0;i < k && node != null;i++,r--){
                res[i] = node;
                for (int j = 0;j < n + (r > 0 ? 1 : 0);j++){    //给每个部分个数计数
                    pre = node;
                    node = node.next;
                }
                pre.next = null;
            }
            return res;
        }
    }
}
