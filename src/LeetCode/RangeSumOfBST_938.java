package LeetCode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 * Note:
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBST_938 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Recursion
    class Solution {

        private int res;

        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null)   return 0;
            helper(root,L,R);
            return res;
        }

        private void helper(TreeNode node, int L, int R){
            if (node == null)   return;
            if (node.val > R)
                helper(node.left,L,R);
            else if (node.val < L)
                helper(node.right,L,R);
            else {
                res += node.val;
                helper(node.left,L,R);
                helper(node.right,L,R);
            }
        }
    }
}
