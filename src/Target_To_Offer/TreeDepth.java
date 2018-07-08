package Target_To_Offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
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
        public int TreeDepth(TreeNode root) {
            return root == null ? 0 : 1 + Math.max(TreeDepth(root.left),TreeDepth(root.right));
        }
    }
    //非递归，层次遍历
    public class Solution_Queue1 {
        public int TreeDepth(TreeNode root) {
            if (root == null)   return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            queue.offer(root);
            while (!queue.isEmpty()){
                int cnt = queue.size();
                while (cnt-- > 0){
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                depth++;
            }
            return depth;
        }
    }

    public class Solution_Queue2 {
        public int TreeDepth(TreeNode root) {
            if (root == null)   return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0, cnt = 0, nextcnt = 1;
            queue.offer(root);
            while (!queue.isEmpty()){
                    TreeNode node = queue.poll();
                    cnt++;
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                    if (cnt == nextcnt){    //当cnt等于nextcnt时，表明这一层已经遍历完
                        depth++;
                        cnt = 0;            //将遍历每层结点的计数君置0
                        nextcnt = queue.size(); //nextcnt值为下一层的结点个数
                    }
                }
            return depth;
        }
    }
}
