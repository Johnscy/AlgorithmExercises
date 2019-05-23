package LeetCode;
import java.util.*;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */

public class MinimumDepthOfBinaryTree_111 {
    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //BFS，层序遍历，Queue
    public class Solution_Queue {
        public int minDepth(TreeNode root) {
            if(root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            queue.offer(root);
            while(!queue.isEmpty()){
                int cnt = queue.size();
                depth++;
                while(cnt-- > 0){
                    TreeNode node = queue.poll();
                    if(node.left == null  && node.right == null)
                        return depth;
                    if(node.left != null)
                        queue.offer(node.left);
                    if(node.right != null)
                        queue.offer(node.right);
                }
            }
            return depth;
        }
    }

    //递归：
    //若为空树返回0；
    //若左子树为空，则返回右子树的最小深度+1；（加1是因为要加上根这一层，下同）
    //若右子树为空，则返回左子树的最小深度+1；
    //若左右子树均不为空，则取左、右子树最小深度的较小值，+1；
    public class Solution_Recursion {
        public int minDepth(TreeNode root) {
            if(root == null)
                return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 || right == 0)
                return 1 + left + right;
            return left < right ? left + 1 : right + 1;
        }
    }
}
