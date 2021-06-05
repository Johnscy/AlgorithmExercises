package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author scy
 * @date 2021/04/26 02:11
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal_145 {

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
        public List<Integer> postorderTraversal(TreeNode root) {
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
            helper(node.left, list);
            helper(node.right, list);
            list.add(node.val);
        }
    }

    class Solution_Iteration {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
//            stackHelper(root, res);
            morrisHelper(root, res);
            return res;
        }

        private void stackHelper(TreeNode root, List<Integer> list) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root, pre = null;
            while (node != null || !stack.empty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else if (!stack.empty()) {
                    node = stack.pop();
                    if (node.right == null || pre == node.right) {
                        list.add(node.val);
                        pre = node;
                        node = null;
                    } else {
                        stack.push(node);
                        node = node.right;
                    }
                }
            }
        }

        private void morrisHelper(TreeNode root, List<Integer> list) {
            //增加虚拟节点处理根节点
            TreeNode dummy = new TreeNode(-1);
            dummy.left = root;
            root = dummy;
            TreeNode node = root, pre = null;
            while (node != null) {
                if (node.left == null) {
                    node = node.right;
                } else {
                    pre = node.left;
                    while (pre.right != null && pre.right != node) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = node;
                        node = node.left;
                    } else {
                        pre.right = null;
                        addReversedList(node.left, list);
                        node = node.right;
                    }
                }
            }
        }

        private void addReversedList(TreeNode startNode, List<Integer> list) {
            TreeNode t = startNode;
            List<Integer> reversedList = new LinkedList<>();
            while (t != null) {
                reversedList.add(0, t.val);
                t = t.right;
            }
            list.addAll(reversedList);
        }
    }
}
