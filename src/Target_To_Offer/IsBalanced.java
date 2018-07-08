package Target_To_Offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 什么是平衡二叉树？如果二叉树中任意结点的左右子树深度相差不超过1，那么它就是平衡二叉树。
 */
public class IsBalanced {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归
    public class Solution_Recursion {
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null)
                return true;
            int left = getTreeDepth(root.left);
            int right = getTreeDepth(root.right);
            return (Math.abs(left - right) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right));
        }
        private int getTreeDepth(TreeNode root){
            return root == null ? 0 : 1 + Math.max(getTreeDepth(root.left),getTreeDepth(root.right));
        }
    }

    //自底向上，后序遍历
    //如果我们用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们就已经遍历了它的左右子树。
    // 只要在遍历每个结点的时候记下它的深度，就可以一次遍历判断每个结点是不是平衡二叉树。
    public class Solution_BU_Array {
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null)
                return true;
            return isBalanced(root,new int[1]);//用辅助数组来存储每个结点的深度
        }

        private boolean isBalanced(TreeNode node, int[] depth){
            if (node == null){
                depth[0] = 0;
                return true;
            }
            boolean left = isBalanced(node.left,depth);
            int leftDepth = depth[0];
            boolean right = isBalanced(node.right,depth);
            int rightDepth = depth[0];
            depth[0] = Math.max(leftDepth,rightDepth) + 1;
            if (left && right && Math.abs(leftDepth - rightDepth) <= 1)
                return true;
             // int[] left = new int[1];
             // int[] right = new int[1];
             // if (isBalanced(node.left, left) && isBalanced(node.right, right) && Math.abs(left[0] - right[0]) <= 1) { {
             //         depth[0] = Math.max(left[0], right[0]) + 1;
             //         return true;
             //     }
            return false;
        }
    }

    //自底向上，后序遍历。。。所以求的是高度
    public class Solution_BU {
        public boolean IsBalanced_Solution(TreeNode root) {
//            if (root == null)
//                return true;
            return height(root)!= -1;
        }
        private int height(TreeNode node){
            if (node == null)
                return 0;
            int leftHeight = height(node.left);     //求左子树高度
            if (leftHeight == -1)
                return -1;
            int rightHeight = height(node.right);   //求右子树高度
            if (rightHeight == -1)
                return -1;
            //判断左右子树高度相差，如果不是平衡的，返回高度 -1；如果是AVL，返回此结点的高度
            return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight,rightHeight) + 1;
        }
    }

    //自底向上，后序遍历。新建内部类，用对象来存储每个结点的深度/高度
    public class Solution_BU_Class {
        public boolean IsBalanced_Solution(TreeNode root) {
            return isBalanced(root, new Holder());
        }
        private class Holder {  //用对象来存每个结点的深度/高度
            int n;
        }
        private boolean isBalanced(TreeNode root, Holder h) {
            if (root == null) {
                h.n = 0;
                return true;
            }
            Holder l = new Holder(), r = new Holder();
            if (isBalanced(root.left, l) && isBalanced(root.right, r)) {
                if (l.n - r.n > 1 || r.n - l.n > 1)
                    return false;
                h.n += (l.n > r.n ? l.n : r.n) + 1;
                return true;
            }
            return false;
        }
    }
}
