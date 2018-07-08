package LeetCode;
import java.util.*;

/**
 *Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //BFS，层序遍历，Queue
    public class Solution {
        public int run(TreeNode root) {
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

    //递归
    public class Solution_Recursion {
        public int run(TreeNode root) {
            if(root == null)
                return 0;
            int left = run(root.left);
            int right = run(root.right);
            if (left == 0 || right == 0)
                return 1 + left + right;
            return left < right ? left + 1 : right + 1;
        }
    }
}
