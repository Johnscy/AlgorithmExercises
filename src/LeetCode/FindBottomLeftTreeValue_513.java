package LeetCode;
import java.util.*;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: 1
 *
 * Example 2:
 * Input:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * Output:  7
 */
public class FindBottomLeftTreeValue_513 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //BFS
    class Solution_BFS {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null)   return Integer.MIN_VALUE;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                root = queue.poll();
                if (root.right != null)
                    queue.add(root.right);
                if (root.left != null)
                    queue.add(root.left);
            }
            return root.val;
        }
    }

    //DFS
    class Solution_DFS {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return Integer.MIN_VALUE;
            return findBottomLeftValue(root,1,new int[]{0,0});
        }

        private int findBottomLeftValue(TreeNode node,int depth,int[] res){
            if (res[1] < depth){
                res[0] = node.val;
                res[1] = depth;
            }
            if (node.left != null)
                findBottomLeftValue(node.left,depth + 1,res);
            if (node.right != null)
                findBottomLeftValue(node.right,depth + 1,res);
            return res[0];
        }
    }
}
