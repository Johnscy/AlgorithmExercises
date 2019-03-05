package LeetCode;
import java.util.*;

/**
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 * Output: [1, 3, 9]
 */
public class FindLargestValueInEachTreeRow_515 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //BFS
    class Solution_BFS {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null)   return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                int maxInRow = Integer.MIN_VALUE;
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    maxInRow = Math.max(maxInRow,node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                res.add(maxInRow);
            }
            return res;
        }
    }

    //DFS
    class Solution_DFS {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root,res,0);
            return res;
        }

        private void helper(TreeNode node, List<Integer> res, int depth){
            if (node == null)
                return;
            if (depth == res.size())
                res.add(node.val);
            else
                res.set(depth,Math.max(res.get(depth),node.val));
            helper(node.left,res,depth + 1);
            helper(node.right,res,depth + 1);
        }
    }
}
