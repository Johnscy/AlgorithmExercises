package Target_To_Offer;
import java.util.Stack;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归
    public class Solution_recursion {
        private TreeNode pre = null;    //暂存上个结点
        private TreeNode head = null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) return null;
            inOrder(pRootOfTree);
            return head;
        }

        private void inOrder(TreeNode node){
            if (node == null)
                return;
            inOrder(node.left);
            if (head == null)
                head = node;    //用head指向头结点，即左子树的最左的叶子结点
            node.left = pre;    //node结点的左指针指向它的左结点
            if (pre != null)
                pre.right = node;//node左结点的右指针指向node
            pre = node;          //继续推进
            inOrder(node.right);
        }
    }

    //非递归
    //用栈来进行中序遍历
    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null)
                return null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = null;   //记录前一个结点！
            TreeNode head = null;   //新双向链表的左侧头！
            while (pRootOfTree != null || !stack.isEmpty()){
                while (pRootOfTree != null){
                    stack.push(pRootOfTree);
                    pRootOfTree = pRootOfTree.left;//找到当前结点的左子树的左叶子结点为止（这个值是当前结点下最小的）
                }
                pRootOfTree = stack.pop();
                if (head == null)
                    head = pRootOfTree;         //将左子树的末端左叶子结点设为头
                if (node != null)
                    node.right = pRootOfTree;   //前后两个结点相互链接
                pRootOfTree.left = node;         //前后两个结点相互链接
                node = pRootOfTree;             //将记录结点推进
                pRootOfTree = pRootOfTree.right;    //遍历结点推进
            }
            return head;
        }
    }
}
