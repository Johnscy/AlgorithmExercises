package LeetCode;
import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths_257 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            Stack<TreeNode> treeNodes = new Stack<>();
            if (root == null)
                return paths;
            treeNodes.push(root);
            while (!treeNodes.isEmpty()){
c
            }
        }
    }
}
