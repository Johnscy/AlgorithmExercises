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

    //Recursion
    class Solution_Recursion {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            if (root != null){
                searchPath(root,"",paths);
            }
            return paths;
        }
        private void searchPath(TreeNode root, String pathStr, List<String> paths){
            if (root.left == null && root.right == null)
                paths.add(pathStr + root.val);
            if (root.left != null)
                searchPath(root.left,pathStr + root.val + "->",paths);
            if (root.right != null)
                searchPath(root.right,pathStr + root.val + "->",paths);
        }
    }

    //BFS + Queue
    class Solution_BFS {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            Queue<TreeNode> treeNodes = new LinkedList<>();
            Queue<String> pathStr = new LinkedList<>();
            if (root == null)
                return paths;
            treeNodes.add(root);
            pathStr.add("");
            while (!treeNodes.isEmpty()){
                TreeNode curNode = treeNodes.poll();
                String preStr = pathStr.poll();
                if (curNode.left == null && curNode.right == null)
                    paths.add(preStr + curNode.val);
                if (curNode.left != null){
                    treeNodes.add(curNode.left);
                    pathStr.add(preStr + curNode.val + "->");
                }
                if (curNode.right != null){
                    treeNodes.add(curNode.right);
                    pathStr.add(preStr + curNode.val + "->");
                }
            }
            return paths;
        }
    }

    //DFS,Stack
    class Solution_DFS {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            Stack<TreeNode> treeNodes = new Stack<>();
            Stack<String> pathStr = new Stack<>();
            if (root == null)
                return paths;
            treeNodes.push(root);
            pathStr.push("");
            while (!treeNodes.isEmpty()){
                TreeNode curNode = treeNodes.pop();
                String preStr = pathStr.pop();
                while (curNode.left != null || curNode.right != null){
                    preStr += curNode.val + "->";
                    curNode = curNode.left;
                    treeNodes.push(curNode);
                    pathStr.push(preStr);
                }
                paths.add(preStr + curNode.val);
            }
            /*while (!treeNodes.isEmpty()){
                TreeNode curNode = treeNodes.pop();
                String preStr = pathStr.pop();
                if (curNode.left == null && curNode.right == null)
                    paths.add(preStr + curNode.val);
                if (curNode.left != null){
                    treeNodes.push(curNode.left);
                    pathStr.push(preStr + curNode.val + "->");
                }
                if (curNode.right != null){
                    treeNodes.push(curNode.right);
                    pathStr.push(preStr + curNode.val + "->");
                }
            }*/
            return paths;
        }
    }
}
