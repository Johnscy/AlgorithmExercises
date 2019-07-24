package LeetCode;

/**
 * @author scy
 * @date 2019/07/23 00:49
 */
/**
 * Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
 * Recall that:
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
 * The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Explanation:
 * The deepest leaves are the nodes with values 2 and 3.
 * The lowest common ancestor of these leaves is the node with value 1.
 * The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
 *
 * Example 2:
 * Input: root = [1,2,3,4]
 * Output: [4]
 *
 * Example 3:
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 */
public class LowestCommonAncestorOfDeepestLeaves_1123 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //DFS
    public class NodeAndDepth{
        TreeNode node;
        int depth;
        NodeAndDepth(TreeNode node,int x){
            this.node = node;
            depth = x;
        }
    }

    class Solution_1 {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            NodeAndDepth nodeAndDepth = getLCA(root,0);
            return nodeAndDepth.node;
        }

        private NodeAndDepth getLCA(TreeNode node,int depth){
            if (node == null) {
                return new NodeAndDepth(null,depth);
            }
            NodeAndDepth l = getLCA(node.left,depth + 1);
            NodeAndDepth r = getLCA(node.right, depth + 1);
            if (l.depth == r.depth) {
                return new NodeAndDepth(node,depth);
            }
            return l.depth > r.depth ? l : r;
        }
    }

    class Solution_2 {
        private int deepest = 0;
        private TreeNode lca;
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            helper(root,0);
            return lca;
        }

        private int helper(TreeNode node,int depth){
            if (node == null){
                return depth - 1;
            }
            deepest = Math.max(deepest,depth);
            int l = helper(node.left,depth + 1);
            int r = helper(node.right,depth + 1);
            if (l == deepest && r == deepest){
                lca = node;
            }
            return l > r ? l : r;
        }
    }
}
