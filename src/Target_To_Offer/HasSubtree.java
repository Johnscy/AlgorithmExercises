package Target_To_Offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 子结构与子树的不同：？
 * 子树的意思是包含了一个结点，就得包含这个结点下的所有节点，一棵大小为n的二叉树有n个子树，就是分别以每个结点为根的子树。
 * 子结构的意思是包含了一个结点，可以只取左子树或者右子树，或者都不取。
 */
public class HasSubtree {
     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }
    public class Solution {
        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if (root2 == null || root1 == null) return false;
            //如果root2是root1的子结构，后面都不用判断了；如果不是，判断root1的左子树包不包含root2；还不是，再判断root1的右子树包不包含root2。
            return isSubTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);

        }
        private boolean isSubTree(TreeNode root1,TreeNode root2){
            if (root2 == null)  //root2比较完了，之前的值都符合，那就是子结构了。
                return true;
            if (root1 == null)  //root1都比较完了，说明没有找到，不是子结构。
                return false;
            if (root1.val != root2.val) //只要一个值不同，就不是子结构。
                return false;
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);  //判断完根结点，值相同，继续判断左右子树。
        }
    }
}
