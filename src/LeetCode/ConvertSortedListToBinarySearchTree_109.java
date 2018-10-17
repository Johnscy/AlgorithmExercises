package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree_109 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Recursion，from root to leaves
    class Solution_Recursion_Root2Leaves {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)   return null;
            if (head.next == null) return new TreeNode(head.val);
            ListNode fast = head, slow = head, endOfLeft = null;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                endOfLeft = slow;
                slow = slow.next;
            }
            endOfLeft.next = null;  //记录左子树的结束结点，将链表断开
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            return root;
        }
    }

    //Recursion，from leaves to root
    class Solution_Recursion_Leaves2Root {
        private ListNode cur;
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);
            int count = 0;
            ListNode node = head;
            this.cur = head;
            while (node != null){
                node = node.next;
                ++count;
            }
            return convert(0,count - 1);
        }

        private TreeNode convert(int start, int end){
            if (start > end)
                return null;
            int mid = start + (end - start) / 2;
            TreeNode left = convert(start,mid - 1);
            TreeNode root = new TreeNode(cur.val);
            cur = cur.next;
            root.left = left;
            TreeNode right = convert(mid + 1,end);
            root.right = right;
            return root;
        }
    }

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
        ListNode dummyRoot = new ConvertSortedListToBinarySearchTree_109().new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ConvertSortedListToBinarySearchTree_109().new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            TreeNode ret = new ConvertSortedListToBinarySearchTree_109().new Solution_Recursion_Root2Leaves().sortedListToBST(head);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
