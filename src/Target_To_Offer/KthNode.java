package Target_To_Offer;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归，中序遍历就是排好序的结点，找到第k个就行
    public class Solution_Recursion {
        private int index = 0;  //计数器
        private TreeNode res;
        TreeNode KthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k < 0)
                return null;
            InOrder(pRoot,k);
        }
        private void InOrder(TreeNode node,int k){
            if (node == null || k < index)
                return;
            InOrder(node.left,k);
            index++;
            if (index == k)
                res = node;
            InOrder(node.right,k);
        }
    }

    //非递归，栈
    public class Solution {
        TreeNode KthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k < 0)
                return null;
            int index = 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = pRoot;
            //stack.push(pRoot);
            while (!stack.isEmpty() || node != null){
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                index++;
                if (index == k)
                    return node;
                if (node.right != null)
                    node = node.right;
            }
            return null;
        }
    }
}
