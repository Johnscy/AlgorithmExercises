package LeetCode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree_104 {
     //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    //DFS，自底而上，简洁版
    class Solution_BToU {
        public int maxDepth(TreeNode root) {
            int max = 0;
            if (root == null)
                return max;
            max = Math.max(max,Math.max(maxDepth(root.left),maxDepth(root.right)));
            return max + 1;
        }
    }

    //DFS，自顶向下
    class Solution_UToB {
        private int max = 0;
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            dFS(root,1);
            return max;
        }
        private void dFS(TreeNode node, int depth){
            if (node == null)   return;
            max = max > depth ? max : depth;
            dFS(node.left,depth + 1);
            dFS(node.right,depth + 1);
        }
    }
}
