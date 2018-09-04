package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class MaximumBinaryTree_654 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归
    class Solution_Recursion {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0)
                return null;
            return construct(nums,0,nums.length - 1);
        }

        private TreeNode construct(int[] nums, int i, int j){
            if (i > j)  return null;
            int maxIndex = i;
            for (int k = i + 1; k <= j; k++) {
                if (nums[k] > nums[maxIndex])
                    maxIndex = k;
            }
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = construct(nums,i,maxIndex - 1);
            root.right = construct(nums,maxIndex + 1,j);
            return root;
        }
    }

    //Stack
    class Solution_Stack {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0)
                return null;
            Deque<TreeNode> stack = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                TreeNode cur = new TreeNode(nums[i]);
                while (!stack.isEmpty() && stack.peek().val < nums[i])
                    cur.left = stack.pop();
                if (!stack.isEmpty())
                    stack.peek().right = cur;
                stack.push(cur);
            }
            return stack.isEmpty() ? null : stack.removeLast();
        }
    }
}
