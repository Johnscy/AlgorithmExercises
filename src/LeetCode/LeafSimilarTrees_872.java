package LeetCode;
import java.util.*;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees_872 {
      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    //DFS，可以直接比较每个叶子结点的值，也可以将叶子结点记录为字符串，然后比较字符串。

    //DFS，用栈保存结点。
    class Solution_StackDFS {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
            else if (root1 == null || root2 == null)
                return false;
            Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
            stack1.push(root1);stack2.push(root2);
            while (!stack1.empty() && !stack2.empty())
                if (dfs(stack1) != dfs(stack2))
                    return false;
            return stack1.empty() && stack2.empty();
        }
        private int dfs(Stack<TreeNode> s){
            while (true){
                TreeNode node = s.pop();
                if (node.right != null)
                    s.push(node.right);
                if (node.left != null)
                    s.push(node.left);
                if (node.left == null && node.right == null)
                    return node.val;
            }
        }
    }

    //DFS，将所有叶子结点的值记录为一个字符串。直接比较两个二叉树的叶子节点字符串就行了。
    class Solution_StringDFS {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
            else if (root1 == null || root2 == null)
                return false;
            StringBuilder root1Leaves = new StringBuilder(), root2Leaves = new StringBuilder();
            traverse(root1,root1Leaves);traverse(root2,root2Leaves);
            return root1Leaves.toString().equals(root2Leaves.toString());
        }
        private void traverse(TreeNode root, StringBuilder sb){
            if (root == null)   return;
            if (root.left == null && root.right == null)
                sb.append(root.val + "-");  //将叶子节点的值接上“-”形成字符串
            traverse(root.left,sb);
            traverse(root.right,sb);
        }
    }

    //效率更高
    class Solution {
        List<Integer> leaf1;
        List<Integer> leaf2;
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            leaf1 = new ArrayList<>();
            leaf2 = new ArrayList<>();
            inorder(root1,leaf1);
            inorder(root2,leaf2);
            if (leaf1.equals(leaf2)) return true;
            return false;

        }

        public void inorder(TreeNode root, List<Integer> leaf){
            if (root==null) return;
            if ((root.left==null)&&(root.right==null)) leaf.add(root.val);
            else{
                inorder(root.left,leaf);
                inorder(root.right,leaf);
            }
        }
    }
}
