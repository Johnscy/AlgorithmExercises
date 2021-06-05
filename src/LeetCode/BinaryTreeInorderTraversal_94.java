package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author scy
 * @date 2021/04/25 00:12
 * 中序遍历(左中右)
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal_94 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution_Recursion {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> inorderList = new LinkedList<>();
            helper(root, inorderList);
            return inorderList;
        }

        private void helper(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }


    public static class Solution_Iteration {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
//            stackHelper(root, res);
            morrisHelper(root, res);
            return res;
        }

        //stack
        private void stackHelper(TreeNode root, List<Integer> res) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.empty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        private void morrisHelper(TreeNode root, List<Integer> res) {
            TreeNode node = root, pre = null;
            while (node != null) {
                if (node.left == null) {
                    res.add(node.val);
                    node = node.right;
                } else {
                    //找到当前节点的左子树的最右节点，这是左子树在中序遍历最后一个节点，将当前结点连在它后面
                    pre = node.left;
                    while (pre.right != null && pre.right != node) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = node;
                        node = node.left;
                    } else {
                        pre.right = null;
                        res.add(node.val);
                        node = node.right;
                    }
                }
            }
        }
    }
}
