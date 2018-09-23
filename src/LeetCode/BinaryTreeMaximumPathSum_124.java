package LeetCode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 */
public class BinaryTreeMaximumPathSum_124 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        private  int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            solution(root);
            return res;
        }
        private int solution(TreeNode root){
            if(root == null)
                return 0;
            int sumNow = 0;
            int leftMax = Math.max(0,solution(root.left));
            int rightMax = Math.max(0,solution(root.right));
            sumNow = leftMax + rightMax + root.val;
            res = Math.max(res,sumNow);
            return Math.max(rightMax,leftMax) + root.val;
        }
    }
}
