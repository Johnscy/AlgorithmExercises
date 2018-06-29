package Target_To_Offer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：BFS，用队列实现。把根结点加入队列，然后出列，判断它的左右子结点是否为空，不为空就入列。一直循环，直到队列为空。
 */
public class PrintFromTopToBottom {

     public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
     }

    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)   return arrayList;
            queue.offer(root);
            while (!queue.isEmpty()){
                int cnt = queue.size();
                while (cnt-- > 0){
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                    arrayList.add(node.val);
                }
            }
            return arrayList;
        }
    }
}
