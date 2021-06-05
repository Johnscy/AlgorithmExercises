package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author scy
 * @date 2021/04/26 00:32
 * <p>
 * 前序遍历(中左右)
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal_144 {

    //Definition for a binary tree node.
    public class TreeNode {
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

    class Solution_Recursion {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            helper(root, res);
            return res;
        }

        private void helper(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            helper(node.left, list);
            helper(node.right, list);
        }
    }

    class Solution_Iteration {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            morrisHelper(root, res);
            return res;
        }

        private void stackHelper(TreeNode root, List<Integer> list) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            stack.push(cur);
            while (!stack.empty()) {
                cur = stack.pop();
                list.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        private void morrisHelper(TreeNode root, List<Integer> list) {
            TreeNode node = root, pre;
            while (node != null) {
                if (node.left == null) {
                    list.add(node.val);
                    node = node.right;
                } else {
                    pre = node.left;
                    while (pre.right != null && pre.right != node) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = node;
                        list.add(node.val);
                        node = node.left;
                    } else {
                        pre.right = null;
                        node = node.right;
                    }
                }
            }
        }
    }
}
