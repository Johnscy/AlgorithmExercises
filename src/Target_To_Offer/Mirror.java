package Target_To_Offer;
import java.util.*;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }

     //递归
    public class Solution {
        public void Mirror(TreeNode root) {
            if(root == null) return;
            if (root.left != null)   Mirror(root.left);
            if (root.right != null)  Mirror(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    /*
   * 非递归的思想，利用队列和栈来做
   * 1.深度优先 stack
   * 2.广度优先 Queue
   * 确定push的规则：left！=null push（left）right！=null push（right）
   * 确定循环体逻辑：左或者右不为空，左右交换
   */

    //深度优先，使用stack
    public class Solution2 {
        public void MirrorDFS(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> s = new Stack<>();
            s.push(root);//入栈
            while (!s.isEmpty()) {
                TreeNode cur = s.pop();//出栈
                if (cur.left != null || cur.right != null) {
                    TreeNode temp = cur.left;
                    cur.left = cur.right;
                    cur.right = temp;
                }
                //确定push的规则：
                if (cur.left != null) s.push(cur.left);
                if (cur.right != null) s.push(cur.right);
            }
        }
    }

    //广度优先，使用queue
    public void MirrorBFS(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//入队
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();//出队
            if(cur.left != null || cur.right != null) {
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            //确定push的规则：
            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);
        }
    }
}
