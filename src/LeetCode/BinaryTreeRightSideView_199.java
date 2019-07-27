package LeetCode;

/**
 * @author scy
 * @date 2019/07/27 14:35
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView_199 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Recursion
    class Solution_Recursion {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            helper(res,root,0);
            return res;
        }

        private void helper(List<Integer> res, TreeNode node, int depth) {
            if (node == null){
                return;
            }
            if (depth == res.size()){
                res.add(node.val);
            }
            helper(res,node.right,depth + 1);
            helper(res,node.left,depth + 1);
        }
    }

    //Queue
    class Solution_Queue {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size-- > 0){
                    TreeNode node = queue.poll();
                    if (size == 0) {
                        res.add(node.val);
                    }
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }

}
