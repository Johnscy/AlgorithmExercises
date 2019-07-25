package LeetCode;

/**
 * @author scy
 * @date 2019/07/26 00:30
 */

/**
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
 * <p>
 * Example 1:
 * Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation:
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */
public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //DFS
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root,root.val,root.val);
        }

        private int dfs(TreeNode node,int max,int min){
            if (node == null){
                return max - min;
            }
            max = Math.max(max,node.val);
            min = Math.min(min,node.val);
            return Math.max(dfs(node.left,max,min),dfs(node.right,max,min));
        }
    }
}
