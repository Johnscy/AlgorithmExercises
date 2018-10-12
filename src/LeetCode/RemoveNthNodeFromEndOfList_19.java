package LeetCode;

import java.io.*;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Follow up:
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList_19 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0)
                return head;
            ListNode toTail = head, preNode = head;
            int len = 1,cnt = n;
            while (cnt-- > 0){
                toTail = toTail.next;
                if (toTail != null)
                    len++;
            }
            if (toTail == null){
                if (len == n)
                    return head.next;
                else
                    return head;
            }
            while (toTail.next != null){
                toTail = toTail.next;
                preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
            return head;
        }
    }

    //
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new RemoveNthNodeFromEndOfList_19().new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new RemoveNthNodeFromEndOfList_19().new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = new RemoveNthNodeFromEndOfList_19().new Solution().removeNthFromEnd(head, n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
